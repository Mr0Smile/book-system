<template>
	<div>
		<el-carousel indicator-position="outside" height="400px" type="card">
			<el-carousel-item v-for="(image, index) in images" :key="index">
				<div class="image-container">
					<img
						class="responsive-image"
						:src="image"
						alt="Carousel Image"
					/>
				</div>
			</el-carousel-item>
		</el-carousel>
	</div>
</template>

<script setup>
import { defineProps } from "vue";

import img1 from "../../assets/imgs/1.jpg";
import img2 from "../../assets/imgs/2.jpg";
import img3 from "../../assets/imgs/3.jpg";
import img4 from "../../assets/imgs/4.jpg";

const props = defineProps({
	images: {
		type: Array,
		default: () => [img1, img2, img3, img4],
	},
});
</script>

<style scoped>
.image-container {
	width: 100%; /* 设置容器宽度 */
	height: 100%; /* 设置容器高度 */
	overflow: hidden; /* 防止图片溢出 */
}

.responsive-image {
	width: 100%; /* 图片宽度100% */
	height: 100%; /* 图片高度100%，确保填满容器 */
	object-fit: contain; /* 使用contain以完整显示图片，可能会留白 */
}
</style>
