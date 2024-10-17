<template>
	<div class="activity-container">
		<div class="heading">活动</div>
		<div class="content-container">
			<div class="content-item" v-for="(item, index) in img" :key="index">
				<img :src="item" alt="" />
				<div class="content-item-text-container">
					<div>活动标题</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
import { defineProps } from "vue";

import img1 from "../../assets/imgs/1.jpg";
import img2 from "../../assets/imgs/2.jpg";
import img3 from "../../assets/imgs/3.jpg";

defineProps({
	img: {
		type: Array,
		default: () => [img1, img2, img3],
	},
});
</script>

<style scoped>
.heading {
	font-size: 24px;
	font-weight: bold;
	margin-bottom: 2%;
}

.content-container {
	display: flex;
}

.content-item {
	height: 160px;
	text-align: center;
	line-height: 200px;
	flex: 1;
	padding: 0.3%;
	position: relative;
	margin: auto;
	cursor: pointer;
}

.content-item img {
	height: 100%;
	width: 100%;
	position: relative;
}

.content-item-text-container {
	position: absolute;
	width: 98%;
	height: 0; /* 初始高度为0 */
	top: 80%;
	transition: height 0.3s; /* 添加过渡效果 */
}

.content-item-text-container div {
	margin: auto;
	width: 100%;
	height: 30px;
	line-height: 30px;
	opacity: 0; /* 初始透明度为0 */
	transition: opacity 0.4s; /* 添加过渡效果 */
	font-weight: bold;
	color: whitesmoke;
}

.content-item:hover .content-item-text-container div {
	opacity: 1; /* 悬浮时改变透明度 */
	background-color: rgba(102, 102, 105, 0.5);
}
</style>
