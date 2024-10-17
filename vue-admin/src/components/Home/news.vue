<template>
	<div class="news-card">
		<title_ Chinese="新闻" English="NEWS"></title_>

		<div v-for="newsItem in news" :key="newsItem.id">
			<div class="news-item">
				<div class="title" style="margin-bottom: 1.5%">
					{{ newsItem.title }}
				</div>
				<div
					class="content"
					style="
						color: #acaba5;
						overflow: hidden;
						display: -webkit-box;
						line-clamp: 3;
						-webkit-box-orient: vertical;
						-webkit-line-clamp: 3;
						margin-bottom: 4%;
					"
				>
					{{ newsItem.content }}
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
import { defineProps, ref } from "vue";

import title_ from "@/components/Home/title.vue";

defineProps({
	news: {
		type: Array,
		default: () => [
			{
				id: 1,
				title: "新闻1",
				content:
					"海明威的一生之中曾荣获不少奖项。他在第一次世界大战期间被授予银制勇敢勋章；1953年，他以《老人与海》一书获得普利策奖 [1]；1954年的《老人与海》又为海明威夺得诺贝尔文学奖。2001年，海明威的《太阳照常升起》 [9]（The Sun Also Rises）与《永别了，武器》两部作品被美国现代图书馆列入“20世纪中的100部最佳英文小说”中。",
			},
			{
				id: 2,
				title: "新闻2",
				content:
					"海明威的一生之中曾荣获不少奖项。他在第一次世界大战期间被授予银制勇敢勋章；1953年，他以《老人与海》一书获得普利策奖 [1]；1954年的《老人与海》又为海明威夺得诺贝尔文学奖。2001年，海明威的《太阳照常升起》 [9]（The Sun Also Rises）与《永别了，武器》两部作品被美国现代图书馆列入“20世纪中的100部最佳英文小说”中。",
			},
			{
				id: 3,
				title: "新闻3",
				content:
					"海明威的一生之中曾荣获不少奖项。他在第一次世界大战期间被授予银制勇敢勋章；1953年，他以《老人与海》一书获得普利策奖 [1]；1954年的《老人与海》又为海明威夺得诺贝尔文学奖。2001年，海明威的《太阳照常升起》 [9]（The Sun Also Rises）与《永别了，武器》两部作品被美国现代图书馆列入“20世纪中的100部最佳英文小说”中。",
			},
		],
	},
});

const activeName = ref(1);
</script>

<style scoped>
.news-card {
	height: 40vh;
}

.news-item {
	margin-bottom: 10px;
}

.content {
	color: #acaba5;
	overflow: hidden;
	display: -webkit-box;
	line-clamp: 3;
	-webkit-box-orient: vertical;
	-webkit-line-clamp: 3;
	margin-bottom: 5%;
}
</style>
