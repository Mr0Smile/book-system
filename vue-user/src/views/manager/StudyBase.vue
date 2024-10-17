<template>
	<div>
		<div class="card" style="margin-bottom: 5px">
			<el-input
				v-model="data.name"
				style="width: 300px; margin-right: 10px"
				placeholder="请输入名称查询"
			/>
			<el-button type="primary" @click="load">查询</el-button>
			<el-button type="info" style="margin: 0 10px" @click="reset"
				>重置</el-button
			>
		</div>

		<div class="card" style="margin-bottom: 5px">
			<el-table :data="data.tableData" stripe>
				<el-table-column
					label="名称"
					prop="studyBaseName"
				></el-table-column>
				<el-table-column label="简介" prop="descr"></el-table-column>
				<el-table-column label="操作" header-align="center" width="160">
					<template #default="scope">
						<el-button
							type="primary"
							@click="gotoArticle(scope.row.articleId)"
							>前往文章</el-button
						>
					</template>
				</el-table-column>
			</el-table>
		</div>

		<div class="card" v-if="data.total">
			<el-pagination
				background
				layout="prev, pager, next"
				v-model:page-size="data.pageSize"
				v-model:current-page="data.pageNum"
				:total="data.total"
			/>
		</div>
	</div>
</template>

<script setup>
import request from "@/utils/request";
import { reactive } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import { useRouter } from "vue-router"; // 引入 Vue Router

const router = useRouter(); // 创建 router 实例

const data = reactive({
	pageNum: 1,
	pageSize: 10,
	total: 0,
	formVisible: false,
	form: {},
	tableData: [],
	name: null,
	categoryList: [],
});

request.get("/category/selectAll").then((res) => {
	data.categoryList = res.data;
});

// 分页查询
const load = () => {
	request
		.get("/studybaseform/selectPage", {
			params: {
				pageNum: data.pageNum,
				pageSize: data.pageSize,
				name: data.name,
			},
		})
		.then((res) => {
			data.tableData = res.data?.list;
			data.total = res.data?.total;
		});
};

const update = () => {
	console.log(data.form);
	request.put("/studybaseform/update", data.form).then((res) => {
		if (res.code === "200") {
			load();
			ElMessage.success("操作成功");
			data.formVisible = false;
		} else {
			ElMessage.error(res.msg);
		}
	});
};

const reset = () => {
	data.name = null;
	load();
};

// 跳转到文章的函数
const gotoArticle = (articleId) => {
	router.push({ name: "article", query: { articleId: articleId } });
};

load();
</script>
