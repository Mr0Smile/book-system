/* empty css                *//* empty css               *//* empty css                    *//* empty css                  *//* empty css               *//* empty css               *//* empty css               *//* empty css                */import{r as p}from"./request-d9b764dc.js";import{a as S,o as g,c as f,h as c,d as o,w as r,i as B,B as D,C as U,D as I,G as J,H as M,I as i,J as P,E as m,K as T,L as $,M as F}from"./index-3f6e6985.js";const O={class:"card",style:{"margin-bottom":"5px"}},q={class:"card",style:{"margin-bottom":"5px"}},A={style:{"margin-bottom":"10px"}},G={key:0,class:"card"},H={class:"dialog-footer"},oe={__name:"Category",setup(K){const e=S({pageNum:1,pageSize:10,total:0,formVisible:!1,form:{},tableData:[],category:null}),d=()=>{p.get("/category/selectPage",{params:{pageNum:e.pageNum,pageSize:e.pageSize,category:e.category}}).then(a=>{var t,s;e.tableData=(t=a.data)==null?void 0:t.list,e.total=(s=a.data)==null?void 0:s.total})},_=()=>{e.form={},e.formVisible=!0},y=a=>{e.form=JSON.parse(JSON.stringify(a)),e.formVisible=!0},b=()=>{p.post("/category/add",e.form).then(a=>{a.code==="200"?(d(),m.success("操作成功"),e.formVisible=!1):m.error(a.msg)})},V=()=>{p.put("/category/update",e.form).then(a=>{a.code==="200"?(d(),m.success("操作成功"),e.formVisible=!1):m.error(a.msg)})},k=()=>{e.form.id?V():b()},x=a=>{P.confirm("删除后数据无法恢复，您确定删除吗?","删除确认",{type:"warning"}).then(t=>{p.delete("/category/delete/"+a).then(s=>{s.code==="200"?(d(),m.success("操作成功")):m.error(s.msg)})}).catch(t=>{})},C=()=>{e.category=null,d()};return d(),(a,t)=>{const s=D,n=U,u=T,h=I,E=J,v=$,N=F,w=M;return g(),f("div",null,[c("div",O,[o(s,{modelValue:e.category,"onUpdate:modelValue":t[0]||(t[0]=l=>e.category=l),style:{width:"300px","margin-right":"10px"},placeholder:"请输入分类名称查询"},null,8,["modelValue"]),o(n,{type:"primary",onClick:d},{default:r(()=>[i("查询")]),_:1}),o(n,{type:"info",style:{margin:"0 10px"},onClick:C},{default:r(()=>[i("重置")]),_:1})]),c("div",q,[c("div",A,[o(n,{type:"primary",onClick:_},{default:r(()=>[i("新增")]),_:1})]),o(h,{data:e.tableData,stripe:""},{default:r(()=>[o(u,{label:"分类名称",prop:"category"}),o(u,{label:"操作","header-align":"center",width:"160"},{default:r(l=>[o(n,{type:"primary",onClick:z=>y(l.row)},{default:r(()=>[i("编辑")]),_:2},1032,["onClick"]),o(n,{type:"danger",onClick:z=>x(l.row.id)},{default:r(()=>[i("删除")]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data"])]),e.total?(g(),f("div",G,[o(E,{background:"",layout:"prev, pager, next","page-size":e.pageSize,"onUpdate:pageSize":t[1]||(t[1]=l=>e.pageSize=l),"current-page":e.pageNum,"onUpdate:currentPage":t[2]||(t[2]=l=>e.pageNum=l),total:e.total},null,8,["page-size","current-page","total"])])):B("",!0),o(w,{title:"分类信息",width:"40%",modelValue:e.formVisible,"onUpdate:modelValue":t[5]||(t[5]=l=>e.formVisible=l),"close-on-click-modal":!1,"destroy-on-close":""},{footer:r(()=>[c("span",H,[o(n,{onClick:t[4]||(t[4]=l=>e.formVisible=!1)},{default:r(()=>[i("取 消")]),_:1}),o(n,{type:"primary",onClick:k},{default:r(()=>[i("保 存")]),_:1})])]),default:r(()=>[o(N,{model:e.form,"label-width":"100px",style:{"padding-right":"50px"}},{default:r(()=>[o(v,{label:"分类名称",prop:"category"},{default:r(()=>[o(s,{modelValue:e.form.category,"onUpdate:modelValue":t[3]||(t[3]=l=>e.form.category=l),autocomplete:"off"},null,8,["modelValue"])]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"])])}}};export{oe as default};