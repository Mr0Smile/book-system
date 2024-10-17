<template>
	<div>
		<h2>书籍内容</h2>
		<div v-for="item in contentList" :key="item.id">
			<!-- 如果 content_type 为 0，显示文字内容 -->
			<div v-if="item.contentType === 0" class="text-content">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{ item.content }}</p>
			</div>
			<!-- 如果 content_type 为 1，显示图片内容 -->
			<div v-else-if="item.contentType === 1" class="image-content">
				<img :src="getImageUrl(item.content)" alt="书籍图片" />
			</div>
		</div>
	</div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import request from "@/utils/request";

const contentList = ref([]); // 存储书籍内容
const route = useRoute(); // 获取当前路由

const fetchContent = () => {
	const articleId = route.query.articleId; // 获取路由参数

	request
		.get(`/content/getByArticleId/${articleId}`)
		.then((response) => {
			if (response.code === "200") {
				contentList.value = response.data; // 将返回的书籍内容存储到 contentList
			}
		})
		.catch((error) => {
			console.error("获取书籍内容失败:", error); // 打印错误信息
		});
};

const getImageUrl = (content) => {
	// 返回图片的完整 URL
	return `http://localhost:9090${content}`;
};

onMounted(() => {
	fetchContent(); // 组件挂载时获取书籍内容
});
</script>

<style scoped>
.text-content p {
	text-indent: 2em; /* 设置第一行缩进2个字符 */
	margin: 10px 0;
}

.image-content img {
	display: block; /* 使图片成为块级元素 */
	margin: 0 auto; /* 图片水平居中 */
	max-width: 100%; /* 确保图片不会超出容器的宽度 */
	max-height: 20vh; /* 图片最大高度为屏幕的五分之一 */
	height: auto; /* 保持图片的纵横比 */
	margin: 10px 0;
}
</style>
