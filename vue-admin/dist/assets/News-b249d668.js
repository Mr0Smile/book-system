/* empty css                *//* empty css               *//* empty css                    *//* empty css                  *//* empty css               *//* empty css               *//* empty css               *//* empty css                */import{r as u}from"./request-d9b764dc.js";import{a as S,o as g,c as _,h as f,d as t,w as a,i as U,B,C as D,D as I,G as J,H as M,I as i,J as P,E as d,K as T,L as $,M as F}from"./index-3f6e6985.js";const O={class:"card",style:{"margin-bottom":"5px"}},q={class:"card",style:{"margin-bottom":"5px"}},A={style:{"margin-bottom":"10px"}},G={key:0,class:"card"},H={class:"dialog-footer"},oe={__name:"News",setup(K){const e=S({pageNum:1,pageSize:10,total:0,formVisible:!1,form:{},tableData:[],title:null}),m=()=>{u.get("/news/selectPage",{params:{pageNum:e.pageNum,pageSize:e.pageSize,title:e.title}}).then(n=>{var o,r;e.tableData=(o=n.data)==null?void 0:o.list,e.total=(r=n.data)==null?void 0:r.total})},b=()=>{e.form={},e.formVisible=!0},V=n=>{e.form=JSON.parse(JSON.stringify(n)),e.formVisible=!0},y=()=>{u.post("/news/add",e.form).then(n=>{n.code==="200"?(m(),d.success("操作成功"),e.formVisible=!1):d.error(n.msg)})},x=()=>{u.put("/news/update",e.form).then(n=>{n.code==="200"?(m(),d.success("操作成功"),e.formVisible=!1):d.error(n.msg)})},k=()=>{e.form.id?x():y()},w=n=>{P.confirm("删除后数据无法恢复，您确定删除吗?","删除确认",{type:"warning"}).then(o=>{u.delete("/news/delete/"+n).then(r=>{r.code==="200"?(m(),d.success("操作成功")):d.error(r.msg)})}).catch(o=>{})},C=()=>{e.title=null,m()};return m(),(n,o)=>{const r=B,s=D,p=T,E=I,h=J,c=$,N=F,v=M;return g(),_("div",null,[f("div",O,[t(r,{modelValue:e.title,"onUpdate:modelValue":o[0]||(o[0]=l=>e.title=l),style:{width:"300px","margin-right":"10px"},placeholder:"请输入标题查询"},null,8,["modelValue"]),t(s,{type:"primary",onClick:m},{default:a(()=>[i("查询")]),_:1}),t(s,{type:"info",style:{margin:"0 10px"},onClick:C},{default:a(()=>[i("重置")]),_:1})]),f("div",q,[f("div",A,[t(s,{type:"primary",onClick:b},{default:a(()=>[i("新增")]),_:1})]),t(E,{data:e.tableData,stripe:""},{default:a(()=>[t(p,{label:"标题",prop:"title"}),t(p,{label:"内容",prop:"content"}),t(p,{label:"作者",prop:"author"}),t(p,{label:"发布时间",prop:"time"}),t(p,{label:"操作","header-align":"center",width:"160"},{default:a(l=>[t(s,{type:"primary",onClick:z=>V(l.row)},{default:a(()=>[i("编辑")]),_:2},1032,["onClick"]),t(s,{type:"danger",onClick:z=>w(l.row.id)},{default:a(()=>[i("删除")]),_:2},1032,["onClick"])]),_:1})]),_:1},8,["data"])]),e.total?(g(),_("div",G,[t(h,{background:"",layout:"prev, pager, next","page-size":e.pageSize,"onUpdate:pageSize":o[1]||(o[1]=l=>e.pageSize=l),"current-page":e.pageNum,"onUpdate:currentPage":o[2]||(o[2]=l=>e.pageNum=l),total:e.total},null,8,["page-size","current-page","total"])])):U("",!0),t(v,{title:"系统公告信息",width:"40%",modelValue:e.formVisible,"onUpdate:modelValue":o[7]||(o[7]=l=>e.formVisible=l),"close-on-click-modal":!1,"destroy-on-close":""},{footer:a(()=>[f("span",H,[t(s,{onClick:o[6]||(o[6]=l=>e.formVisible=!1)},{default:a(()=>[i("取 消")]),_:1}),t(s,{type:"primary",onClick:k},{default:a(()=>[i("保 存")]),_:1})])]),default:a(()=>[t(N,{model:e.form,"label-width":"100px",style:{"padding-right":"50px"}},{default:a(()=>[t(c,{label:"标题",prop:"title"},{default:a(()=>[t(r,{modelValue:e.form.title,"onUpdate:modelValue":o[3]||(o[3]=l=>e.form.title=l),autocomplete:"off"},null,8,["modelValue"])]),_:1}),t(c,{label:"作者",prop:"title"},{default:a(()=>[t(r,{modelValue:e.form.author,"onUpdate:modelValue":o[4]||(o[4]=l=>e.form.author=l),autocomplete:"off"},null,8,["modelValue"])]),_:1}),t(c,{label:"内容",prop:"content"},{default:a(()=>[t(r,{modelValue:e.form.content,"onUpdate:modelValue":o[5]||(o[5]=l=>e.form.content=l),autocomplete:"off",type:"textarea"},null,8,["modelValue"])]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"])])}}};export{oe as default};
