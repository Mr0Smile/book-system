<template>
  <div>
    <div class="card" style="margin-bottom: 10px;">
      <el-button @click="loadCategory(null)">全部</el-button>
      <el-button v-for="item in data.categoryList" :key="item.id" @click="loadCategory(item.id)">{{ item.category }}</el-button>
    </div>

    <div style="margin-bottom: 10px;">
      <el-input v-model="data.name" placeholder="请输入商品名称" size="large" style="width: 300px;"></el-input>
      <el-button type="primary" @click="load">查询</el-button>
    </div>

    <el-row :gutter="10" v-if="data.total > 0" >
      <el-col :span="6" v-for="item in data.goodsList" :key="item.id">
        <div class="card">
          <img :src="item.img" alt="" style="width: 100%; height: 280px;">
          <div style="font-size: 18px; margin: 5px 0;" color="#333">{{ item.name }}</div>
          <el-tooltip :content="item.descr" placement="bottom" effect="light">
            <div style="font-size: 14px; margin: 5px 0;" color="#666 min-height: 20px;" class="line1" v-if="item.descr != null">{{ item.descr }}</div>
            <div style="font-size: 14px; margin: 5px 0;" color="#666 min-height: 20px;" v-else>暂无简介</div>
          </el-tooltip>
          <div>
            <el-tag type="success" style="margin-right: 5px;" v-if="item.specials != null">{{ item.specials}}</el-tag>
            <el-tag type="success" style="margin-right: 5px;" v-else>暂无标签</el-tag>
          </div>
          <div style="margin: 5px 0; display: flex; align-items: center;">
            <div style="flex:1">
              <strong style="color: red; font-size: 18px;">¥{{ item.price }}</strong>/{{ item.unit }}
            </div>
            <div style="flex:1">
              库存：{{ item.stock }}
            </div>
            <div>
              <el-input-number :min="0" :max="item.stock" v-model="item.num" style="width: 100px;" @change="handleBuy(item)"></el-input-number>
            </div>
          </div>
          <div style="text-align: right;">
            总价：<strong style="margin-right:20px; display: inline-block; min-width: 40px; color: red; ">¥{{ item.total }}</strong>
            <el-button style="margin: 0 5px;" type="primary" size="small" @click="Buy(item)">购买</el-button>
          </div>
        </div>
      </el-col>
    </el-row>

    <div v-else style="text-align: center; padding: 50px 0; color: #888;">
      <h2>没有找到相关商品</h2>
    </div>

    <div  v-if="data.total" style="margin-top: 10px;">
      <el-pagination background layout="prev, pager, next" v-model:page-size="data.pageSize" v-model:current-page="data.pageNum" :total="data.total"/>
    </div>
  </div>
</template>

<script setup>
import request from "@/utils/request";
import  { reactive } from "vue";
import {ElMessage} from "element-plus";

const data = reactive({
  user: JSON.parse(localStorage.getItem('system-user') || '{}'),
  categoryList: [],
  pageNum: 1,
  pageSize: 10,
  total: 0,
  goodsList: [],
  activeCategory: null,
})

// 获取商品分类列表
request.get('/category/selectAll').then(res => {
  data.categoryList = res.data
})


// 分页查询
const load = () => {
  request.get('/goods/selectPage', {
    params: {
      pageNum: data.pageNum,
      pageSize: data.pageSize,
      name: data.name,
      category_id: data.activeCategory
    }
  }).then(res => {
    data.goodsList = res.data?.list
    data.total = res.data?.total
    data.goodsList.forEach(item => {
      item.num = 0
      item.total = 0
    })
  })
}

const handleBuy = (goods) => {
  goods.total = (goods.num * goods.price).toFixed(2)
}

// 购买
const Buy = (goods) => {
 let ordersData = {
   goods_id: goods.id,
   num: goods.num,
   user_id: data.user.id
 }
 if (ordersData.num == 0) {
    ElMessage.error('购买数量不能为0')
 } else {
   request.post('/orders/add', ordersData).then(res => {
     if (res.code === '200') {
       ElMessage.success('下单成功')
       goods.num = 0
       goods.total = 0
     } else {
       ElMessage.error(res.msg)
     }
   })
 }
}

const loadCategory = (category_id) => {
  data.activeCategory = category_id
  load()
}

load()

</script>