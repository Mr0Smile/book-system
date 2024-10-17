<template>
	<div class="heading">
		<div class="heading-container">
			<div class="heading-en">{{ English }}</div>
			<div class="divider"></div>
			<div class="heading-cn">{{ Chinese }}</div>
		</div>
		<div class="more">更多 ></div>
	</div>
</template>

<style scoped>
.heading {
	text-align: center;
	clear: both;
	height: 5vh;
}

.heading-container {
	height: 100%;
	display: inline-block;
	position: relative;
}

.heading-en {
	font-size: small;
	display: inline;
	height: 100%;
	font-weight: 100;
	position: relative;
	bottom: 30%;
}

.divider {
	position: relative;
	top: 40%;
	display: inline-block;
	width: 0.2vh;
	height: 100%;
	background-image: linear-gradient(
		to top,
		rgb(0, 0, 0) 0%,
		rgba(0, 0, 0, 0) 100%
	);
	margin: 0 0.2em 0 0.4em;
	transform: rotate(20deg);
}

.divider {
	position: relative;
	top: 30%;
	display: inline-block;
	width: 0;
	height: 0;
	border-left: 1.5px solid transparent;
	border-right: 1.5px solid transparent;
	border-bottom: 30px solid #a073597b;
	transform: rotate(20deg);
}

.heading-cn {
	display: inline;
	height: 100%;
	font-weight: bold;
}

.more {
	font-size: x-small;
	color: #c0a18b;
	float: right;
	font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS",
		sans-serif;
	margin-top: 10px;
	cursor: pointer;
}
</style>

<script setup>
import { defineProps } from "vue";
defineProps({
	English: {
		type: String,
		default: "ENGLISH",
	},
	Chinese: {
		type: String,
		default: "中文",
	},
});
</script>
