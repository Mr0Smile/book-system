<template>
	<div>
		<div class="card" style="margin-bottom: 5px">
			<el-input
				v-model="data.order_no"
				style="width: 300px; margin-right: 10px"
				placeholder="请输入订单编号查询"
			></el-input>
			<el-button type="primary" @click="load">查询</el-button>
			<el-button type="info" style="margin: 0 10px" @click="reset"
				>重置</el-button
			>
		</div>

		<div class="card" style="margin-bottom: 5px">
			<el-table :data="data.tableData" stripe>
				<el-table-column
					label="订单编号"
					prop="order_no"
				></el-table-column>
				<el-table-column
					label="商品名称"
					prop="goods_name"
				></el-table-column>
				<el-table-column label="商品图片" prop="goods_img">
					<template #default="scope">
						<el-image
							style="border-radius: 5%; max-width: 50px"
							:src="scope.row.goods_img"
							:preview-src-list="[scope.row.goods_img]"
							:preview-teleported="true"
						></el-image>
					</template>
				</el-table-column>
				<el-table-column label="购买数量" prop="num"></el-table-column>
				<el-table-column
					label="下单人"
					prop="user_name"
				></el-table-column>
				<el-table-column label="订单状态" prop="status">
					<template #default="scope">
						<el-tag
							v-if="scope.row.status === '待支付'"
							type="warning"
							>待支付</el-tag
						>
						<el-tag
							v-if="scope.row.status === '待发货'"
							type="success"
							>待发货</el-tag
						>
						<el-tag v-if="scope.row.status === '待收货'" type="info"
							>待收货</el-tag
						>
						<el-tag
							v-if="scope.row.status === '已收货'"
							type="success"
							>已收货</el-tag
						>
						<el-tag
							v-if="scope.row.status === '已取消'"
							type="danger"
							>已取消</el-tag
						>
					</template>
				</el-table-column>
				<el-table-column label="下单时间" prop="time"></el-table-column>
				<el-table-column label="操作" header-align="center" width="160">
					<template #default="scope">
						<el-button
							v-if="scope.row.status === '待支付'"
							type="danger"
							@click="
								changeStatus(scope.row, '已取消'),
									candleOrder(
										scope.row.goods_id,
										scope.row.num
									)
							"
							>取消</el-button
						>
						<el-button
							v-if="
								data.user.role === 'USER' &&
								scope.row.status === '待支付'
							"
							type="danger"
							@click="changeStatus(scope.row, '待发货')"
							>支付</el-button
						>
						<el-button
							v-if="
								data.user.role === 'ADMIN' &&
								scope.row.status === '待发货'
							"
							type="danger"
							@click="changeStatus(scope.row, '待收货')"
							>发货</el-button
						>
						<el-button
							v-if="
								data.user.role === 'USER' &&
								scope.row.status === '待收货'
							"
							type="danger"
							@click="changeStatus(scope.row, '已收货')"
							>收货</el-button
						>
						<el-button
							v-if="data.user.role === 'ADMIN'"
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
	</div>
</template>

<script setup>
import request from "@/utils/request";
import { reactive } from "vue";
import { ElMessageBox, ElMessage } from "element-plus";

// 文件上传的接口地址
const uploadUrl = import.meta.env.VITE_BASE_URL + "/files/upload";

const data = reactive({
	user: JSON.parse(localStorage.getItem("system-user") || "{}"),
	pageNum: 1,
	pageSize: 10,
	total: 0,
	formVisible: false,
	form: {},
	tableData: [],
	order_no: null,
});

// 分页查询
const load = () => {
	if (data.user.role === "USER") {
		request
			.get("/orders/selectPage", {
				params: {
					pageNum: data.pageNum,
					pageSize: data.pageSize,
					order_no: data.order_no,
					user_id: data.user.id,
				},
			})
			.then((res) => {
				data.tableData = res.data?.list;
				data.total = res.data?.total;
			});
	} else {
		request
			.get("/orders/selectPage", {
				params: {
					pageNum: data.pageNum,
					pageSize: data.pageSize,
					order_no: data.order_no,
				},
			})
			.then((res) => {
				data.tableData = res.data?.list;
				data.total = res.data?.total;
			});
	}
};

// 状态修改
const changeStatus = (row, status) => {
	row.status = status;
	console.log(row);
	console.log(data.form);
	request.put("/orders/update", row).then((res) => {
		if (res.code === "200") {
			load();
			ElMessage.success("操作成功");
			data.formVisible = false;
		} else {
			ElMessage.error(res.msg);
		}
	});
};

// 弹窗保存
const save = () => {
	// data.form有id就是更新，没有就是新增
	data.form.id ? update() : add();
};

// 删除
const handleDelete = (id) => {
	ElMessageBox.confirm("删除后数据无法恢复，您确定删除吗?", "删除确认", {
		type: "warning",
	})
		.then((res) => {
			request.delete("/orders/delete/" + id).then((res) => {
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

const candleOrder = (goods_id, num) => {
	request
		.get("/goods/cancelOrder", {
			params: {
				goods_id: goods_id,
				num: num,
			},
		})
		.then((res) => {
			if (res.code === "200") {
				load();
				ElMessage.success("操作成功");
				data.formVisible = false;
			} else {
				console.log(res);
				ElMessage.error(res.msg);
			}
		});
};

// 重置
const reset = () => {
	data.order_no = null;
	load();
};

// 处理文件上传的钩子
const handleImgSuccess = (res) => {
	data.form.avatar = res.data; // res.data就是文件上传返回的文件路径，获取到路径后赋值表单的属性
};

load();
</script>
