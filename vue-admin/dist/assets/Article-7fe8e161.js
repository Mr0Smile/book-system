import{_ as i,z as u,W as p,A as h,o,c,F as f,e as m,h as a,t as v,i as y,p as g,n as I}from"./index-3f6e6985.js";import{r as k}from"./request-d9b764dc.js";/* empty css                */const x=n=>(g("data-v-f68cd205"),n=n(),I(),n),A=x(()=>a("h2",null,"书籍内容",-1)),B={key:0,class:"text-content"},S={key:1,class:"image-content"},q=["src"],C={__name:"Article",setup(n){const r=u([]),l=p(),_=()=>{const s=l.query.articleId;k.get(`/content/getByArticleId/${s}`).then(t=>{t.code==="200"&&(r.value=t.data)}).catch(t=>{console.error("获取书籍内容失败:",t)})},d=s=>`http://localhost:9090${s}`;return h(()=>{_()}),(s,t)=>(o(),c("div",null,[A,(o(!0),c(f,null,m(r.value,e=>(o(),c("div",{key:e.id},[e.contentType===0?(o(),c("div",B,[a("p",null,"     "+v(e.content),1)])):e.contentType===1?(o(),c("div",S,[a("img",{src:d(e.content),alt:"书籍图片"},null,8,q)])):y("",!0)]))),128))]))}},T=i(C,[["__scopeId","data-v-f68cd205"]]);export{T as default};