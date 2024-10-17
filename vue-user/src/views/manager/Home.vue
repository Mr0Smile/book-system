<template>
	<div class="clearfix">
		<carousel :images="images"></carousel>

		<div class="clearfix" style="clear: both">
			<div class="home-card" style="width: 60%">
				<activity></activity><activity></activity>
			</div>

			<news class="home-card" style="width: 35%; margin: 0 0 0 3%"></news>
		</div>

		<div class="clearfix" style="clear: both">
			<a1 class="home-card" style="width: 55%"></a1>

			<a2 class="home-card" style="width: 42%; margin: 0 0 0 3%"></a2>
		</div>
	</div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import request from "@/utils/request";

import carousel from "@/components/Home/carousel.vue";
import activity from "@/components/Home/activity.vue";
import news from "@/components/Home/news.vue";
import a1 from "@/components/Home/a1.vue";
import a2 from "@/components/Home/a2.vue";

const data = reactive({
	admin: JSON.parse(localStorage.getItem("system-admin") || "{}"),
	notice: [], // 这里初始化 notice 数组
});

// 在组件挂载后请求数据
onMounted(() => {
	request
		.get("/notice/selectAll")
		.then((res) => {
			data.notice = res.data; // 更新数据
		})
		.catch((error) => {
			console.error("获取活动数据失败:", error); // 处理错误
		});
});

defineEmits(["updateUser"]);
</script>

<style>
@import "../../assets/css/home.css";

.clearfix::after {
	content: "";
	display: table;
	clear: both;
}
</style>
