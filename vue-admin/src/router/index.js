import { createRouter, createWebHistory } from "vue-router";

const routes = [
	{
		path: "/",
		component: () => import("@/views/Manager.vue"),
		redirect: "/home",
		children: [
			// 首页
			{
				path: "home",
				name: "home",
				params: {
					showText: "首页",
					role: null,
					icon: "HomeFilled",
					show: true,
				},
				component: () => import("@/views/manager/Home.vue"),
			},
			// 购物页
			{
				path: "buy",
				name: "buy",
				params: {
					showText: "商城",
					role: "USER",
					icon: "Goods",
					show: true,
				},
				component: () => import("@/views/manager/Buy.vue"),
			},
			// 订单管理
			{
				path: "orders",
				name: "orders",
				params: { showText: "订单管理", icon: "Tickets", show: true },
				component: () => import("@/views/manager/Orders.vue"),
			},
			// 特色活动管理
			{
				path: "notice",
				name: "notice",
				params: {
					showText: "特色活动管理",
					role: "ADMIN",
					icon: "Bell",
					show: true,
				},
				component: () => import("@/views/manager/Notice.vue"),
			},
			// 文创商品管理
			{
				path: "",
				name: "",
				params: {
					showText: "商品管理",
					role: "ADMIN",
					icon: "Menu",
					index: "1",
					show: true,
				},
				children: [
					// 商品分类管理
					{
						path: "category",
						name: "category",
						params: {
							showText: "商品分类管理",
							icon: "Menu",
							show: true,
						},
						component: () => import("@/views/manager/Category.vue"),
					},
					// 商品信息管理
					{
						path: "goods",
						name: "goods",
						params: {
							showText: "商品信息管理",
							icon: "Goods",
							show: true,
						},
						component: () => import("@/views/manager/Goods.vue"),
					},
					// 商品进货管理
					{
						path: "goodsIn",
						name: "goodsIn",
						params: {
							showText: "商品进货管理",
							icon: "SoldOut",
							show: true,
						},
						component: () => import("@/views/manager/GoodsIn.vue"),
					},
				],
			},
			// 用户管理
			{
				path: "",
				name: "",
				params: {
					showText: "用户管理",
					role: "ADMIN",
					icon: "Memo",
					index: "2",
					show: true,
				},
				children: [
					// 管理员管理
					{
						path: "admin",
						name: "admin",
						params: {
							showText: "管理员管理",
							icon: "User",
							show: true,
						},
						component: () => import("@/views/manager/Admin.vue"),
					},
					// 普通用户管理
					{
						path: "user",
						name: "user",
						params: {
							showText: "普通用户管理",
							icon: "User",
							show: true,
						},
						component: () => import("@/views/manager/User.vue"),
					},
				],
			},
			// 个人资料
			{
				path: "person",
				name: "person",
				params: { showText: "个人资料", icon: "User", show: true },
				component: () => import("@/views/manager/Person.vue"),
			},
			// 修改密码
			{
				path: "password",
				name: "password",
				params: { showText: "修改密码", icon: "Lock", show: true },
				component: () => import("@/views/manager/Password.vue"),
			},
			// 文章模版页
			{
				path: "article", // 使用动态参数 myData
				name: "article",
				component: () => import("@/views/manager/Article.vue"),
				params: { show: false }, // 导航栏不显示
			},
		],
	},
	{ path: "/login", component: () => import("@/views/Login.vue") },
	{ path: "/register", component: () => import("@/views/Register.vue") },
];

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes,
});

export default router;
