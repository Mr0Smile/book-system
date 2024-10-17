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
			<div style="margin-bottom: 10px">
				<el-button type="primary" @click="handleAdd">新增</el-button>
			</div>
			<el-table :data="data.tableData" stripe>
				<el-table-column
					label="名称"
					prop="studyBaseName"
				></el-table-column>
				<el-table-column label="简介" prop="descr"></el-table-column>
				<el-table-column label="操作" header-align="center" width="300">
					<template #default="scope">
						<el-button
							type="primary"
							@click="gotoArticle(scope.row.articleId)"
							>前往文章</el-button
						>
						<el-button type="primary" @click="handleEdit(scope.row)"
							>编辑</el-button
						>
						<el-button
							type="danger"
							@click="handleDelete(scope.row.id)"
							>删除</el-button
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

		<el-dialog
			title="研学基地信息"
			width="40%"
			v-model="data.formVisible"
			:close-on-click-modal="false"
			destroy-on-close
		>
			<el-form
				:model="data.form"
				label-width="100px"
				style="padding-right: 50px"
			>
				<el-form-item label="名称" prop="studyBaseName">
					<el-input
						v-model="data.form.studyBaseName"
						autocomplete="off"
					/>
				</el-form-item>
				<el-form-item label="简介" prop="descr">
					<el-input
						v-model="data.form.descr"
						autocomplete="off"
						type="textarea"
					/>
				</el-form-item>
			</el-form>
			<template #footer>
				<span class="dialog-footer">
					<el-button @click="data.formVisible = false"
						>取 消</el-button
					>
					<el-button type="primary" @click="save">保 存</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>

<script setup>
import request from "@/utils/request";
import { reactive } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";
import { useRouter } from "vue-router"; // 引入 Vue Router

const router = useRouter(); // 创建 router 实例

// 文件上传的接口地址
const uploadUrl = import.meta.env.VITE_BASE_URL + "/files/upload";

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

const handleAdd = () => {
	data.formVisible = true;
};

const handleEdit = (row) => {
	data.form = JSON.parse(JSON.stringify(row));
	data.formVisible = true;
};

const add = () => {
	request.post("/studybaseform/add", data.form).then((res) => {
		if (res.code === "200") {
			load();
			ElMessage.success("操作成功");
			data.formVisible = false;
		} else {
			ElMessage.error(res.msg);
		}
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

const save = () => {
	data.form.id ? update() : add();
};

const handleDelete = (id) => {
	ElMessageBox.confirm("删除后数据无法恢复，您确定删除吗?", "删除确认", {
		type: "warning",
	})
		.then((res) => {
			request.delete("/studybaseform/delete/" + id).then((res) => {
				if (res.code === "200") {
					load();
					ElMessage.success("操作成功");
				} else {
					ElMessage.error(res.msg);
				}
			});
		})
		.catch((err) => {});
};

const reset = () => {
	data.name = null;
	load();
};

// 跳转到文章的函数
const gotoArticle = (articleId) => {
	router.push({ name: "article", query: { articleId: articleId } });
};

const handleImgSuccess = (res) => {
	data.form.img = res.data;
};

load();
</script>
