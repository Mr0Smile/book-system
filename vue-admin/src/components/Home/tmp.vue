<template>
	<div class="news-card">
		<div class="heading">新闻</div>

		<div>
			<el-card style="max-width: 480px; width: 100%">
				<el-collapse v-model="activeName" accordion>
					<el-collapse-item
						:name="newsItem.id"
						v-for="newsItem in news"
						:key="newsItem.id"
					>
						<template #title>
							<div class="title">{{ newsItem.title }}</div>
						</template>
						<div class="content">
							{{ newsItem.content }}
						</div>
					</el-collapse-item>
				</el-collapse>
			</el-card>
		</div>
	</div>
</template>

<script setup>
import { defineProps, ref } from "vue";
defineProps({
	news: {
		type: Array,
		default: () => [
			{ id: 1, title: "新闻1", content: "内容1" },
			{ id: 2, title: "新闻2", content: "内容2" },
			{ id: 3, title: "新闻3", content: "内容3" },
			{ id: 4, title: "新闻4", content: "内容4" },
		],
	},
});

const activeName = ref(1);
</script>

<style scoped>
.news-card {
	height: 40vh;
}

.heading{
	text-align: center;
}
</style>
