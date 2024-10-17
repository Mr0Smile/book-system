<template>
	<div style="width: 100%">
		<div class="heading">研学基地</div>
		<div image-container><img :src="img" alt="" /></div>
	</div>
</template>

<script setup>
import { defineProps } from "vue";

import img1 from "../../assets/imgs/1.jpg";

defineProps({
	img: {
		type: String,
		default: img1,
	},
});
</script>

<style scoped>
.image-container {
	width: 100%;
	height: 400px;
	position: relative;
}

img {
	width: 100%;
	height: 100%;
	object-fit: cover;
}
</style>
