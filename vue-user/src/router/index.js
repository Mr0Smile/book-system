// import { createRouter, createWebHistory } from "vue-router";

// const routes = [
// 	{
// 		path: "/",
// 		component: () => import("@/views/Manager.vue"),
// 		redirect: "/home",
// 		children: [
// 			// 首页
// 			{
// 				path: "home",
// 				name: "home",
// 				params: {
// 					showText: "首页",
// 					role: null,
// 					icon: "HomeFilled",
// 					show: true,
// 				},
// 				component: () => import("@/views/manager/Home.vue"),
// 			},
// 			// 购物页
// 			{
// 				path: "buy",
// 				name: "buy",
// 				params: {
// 					showText: "商城",
// 					role: "USER",
// 					icon: "Goods",
// 					show: true,
// 				},
// 				component: () => import("@/views/manager/Buy.vue"),
// 			},
// 			// 订单管理
// 			{
// 				path: "orders",
// 				name: "orders",
// 				params: { showText: "订单管理", icon: "Tickets", show: true },
// 				component: () => import("@/views/manager/Orders.vue"),
// 			},
// 			// 个人资料
// 			{
// 				path: "person",
// 				name: "person",
// 				params: { showText: "个人资料", icon: "User", show: true },
// 				component: () => import("@/views/manager/Person.vue"),
// 			},
// 			// 修改密码
// 			{
// 				path: "password",
// 				name: "password",
// 				params: { showText: "修改密码", icon: "Lock", show: true },
// 				component: () => import("@/views/manager/Password.vue"),
// 			},
// 			// 文章模版页
// 			{
// 				path: "article", // 使用动态参数 myData
// 				name: "article",
// 				component: () => import("@/views/manager/Article.vue"),
// 				params: { show: false }, // 导航栏不显示
// 			},
// 		],
// 	},
// 	{ path: "/login", component: () => import("@/views/Login.vue") },
// 	{ path: "/register", component: () => import("@/views/Register.vue") },
// ];

// const router = createRouter({
// 	history: createWebHistory(import.meta.env.BASE_URL),
// 	routes,
// });

// export default router;
import { createRouter, createWebHistory } from "vue-router";

// 提前加载所有需要的组件
const Manager = () => import("@/views/Manager.vue");
const Home = () => import("@/views/manager/Home.vue");
const Buy = () => import("@/views/manager/Buy.vue");
const Orders = () => import("@/views/manager/Orders.vue");
const Person = () => import("@/views/manager/Person.vue");
const Password = () => import("@/views/manager/Password.vue");
const Article = () => import("@/views/manager/Article.vue");
const Login = () => import("@/views/Login.vue");
const Register = () => import("@/views/Register.vue");

const routes = [
	{
		path: "/",
		component: Manager,
		redirect: "/home",
		children: [
			{
				path: "home",
				name: "home",
				params: {
					showText: "首页",
					role: null,
					icon: "HomeFilled",
					show: true,
				},
				component: Home,
			},
			{
				path: "buy",
				name: "buy",
				params: {
					showText: "商城",
					role: "USER",
					icon: "Goods",
					show: true,
				},
				component: Buy,
			},
			{
				path: "orders",
				name: "orders",
				params: { showText: "订单管理", icon: "Tickets", show: true },
				component: Orders,
			},
			{
				path: "person",
				name: "person",
				params: { showText: "个人资料", icon: "User", show: true },
				component: Person,
			},
			{
				path: "password",
				name: "password",
				params: { showText: "修改密码", icon: "Lock", show: true },
				component: Password,
			},
			{
				path: "article",
				name: "article",
				component: Article,
				params: { show: false },
			},
		],
	},
	{ path: "/login", component: Login },
	{ path: "/register", component: Register },
];

const router = createRouter({
	history: createWebHistory(import.meta.env.BASE_URL),
	routes,
});

export default router;
