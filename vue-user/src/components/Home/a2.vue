<template>
	<div class="a2-card">
		<title_ Chinese="活动预告" English="UPCOMING EVENTS"></title_>

		<div v-for="(item, index) in data" :key="index">
			<div class="img-container" v-if="index < 2">
				<img :src="item.img" />
				<div class="text-container">
					<div>活动标题</div>
				</div>
			</div>

			<div v-if="index === 2" style="height: 10px; clear: both"></div>

			<li class="list-item" v-if="index >= 2">
				{{ item.title }}
			</li>
		</div>
	</div>
</template>

<style scoped>
.a2-card {
	height: 40vh;
}

.img-container {
	height: 160px;
	text-align: center;
	line-height: 200px;
	width: 50%;
	padding: 0.3%;
	position: relative;
	margin: auto;
	cursor: pointer;
	float: left;
}

.img-container img {
	height: 100%;
	width: 100%;
	position: relative;
}

.text-container {
	position: absolute;
	width: 99.4%;
	height: 0; /* 初始高度为0 */
	top: 80%;
	transition: height 0.3s; /* 添加过渡效果 */
}

.text-container div {
	margin: auto;
	width: 100%;
	height: 30px;
	line-height: 30px;
	/* opacity: 0;  */
	transition: opacity 0.4s; /* 添加过渡效果 */
	font-weight: bold;
	color: whitesmoke;
	background-color: rgba(102, 102, 105, 0.5);
}

.list-item {
	margin: 5% 0;
	color: #0c1e53;
	cursor: pointer;
	font-weight: bold;
	padding: 10px;
	margin: 0;
}

.list-item:hover {
	color: #a07359;
	background-color: #d9d6d4a1;
}
</style>

<script setup>
import { defineProps, ref } from "vue";

import title_ from "@/components/Home/title.vue";

import img1 from "../../assets/imgs/1.jpg";
import img2 from "../../assets/imgs/2.jpg";
import img3 from "../../assets/imgs/3.jpg";
import img4 from "../../assets/imgs/4.jpg";

defineProps({
	data: {
		type: Array,
		default: () => [
			{
				id: 1,
				title: "新闻1",
				img: img1,
			},
			{
				id: 2,
				title: "新闻2",
				img: img2,
			},
			{
				id: 3,
				title: "新闻3",
				img: img3,
			},
			{
				id: 4,
				title: "新闻4",
				img: img4,
			},
			{
				id: 5,
				title: "新闻5",
				img: img3,
			},
			{
				id: 6,
				title: "新闻6",
				img: img4,
			},
			{
				id: 7,
				title: "新闻7",
				img: img3,
			},
			{
				id: 8,
				title: "新闻8",
				img: img4,
			},
		],
	},
});
</script>
