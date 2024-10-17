<template>
	<div>
		<div class="heading">特色活动</div>

		<el-timeline class="timeline">
			<el-timeline-item
				v-for="(item, index) in notice"
				:key="index"
				:timestamp="item.time"
				placement="top"
			>
				<el-card>
					<div class="title">{{ item.title }}</div>
					<p>{{ item.content }}</p>
				</el-card>
			</el-timeline-item>
		</el-timeline>
	</div>
</template>

<script setup>
import { defineProps } from "vue";

const props = defineProps({
	notice: {
		type: Array,
		default: () => [],
	},
});
</script>

<style scoped>
.heading {
	margin: 3% 0; /* 上下边距 */
}

.timeline {
	width: 100%; /* Timeline 宽度 */
}
</style>
