import{_ as i,r as u,a0 as p,o as h,e as o,i as c,F as f,j as m,h as a,t as v,l as y,A as g,B as I}from"./index-c150de53.js";import{r as k}from"./request-9dc1f99e.js";/* empty css                */const x=s=>(g("data-v-f68cd205"),s=s(),I(),s),A=x(()=>a("h2",null,"书籍内容",-1)),B={key:0,class:"text-content"},S={key:1,class:"image-content"},q=["src"],C={__name:"Article",setup(s){const r=u([]),l=p(),_=()=>{const n=l.query.articleId;k.get(`/content/getByArticleId/${n}`).then(t=>{t.code==="200"&&(r.value=t.data)}).catch(t=>{console.error("获取书籍内容失败:",t)})},d=n=>`http://localhost:9090${n}`;return h(()=>{_()}),(n,t)=>(o(),c("div",null,[A,(o(!0),c(f,null,m(r.value,e=>(o(),c("div",{key:e.id},[e.contentType===0?(o(),c("div",B,[a("p",null,"     "+v(e.content),1)])):e.contentType===1?(o(),c("div",S,[a("img",{src:d(e.content),alt:"书籍图片"},null,8,q)])):y("",!0)]))),128))]))}},T=i(C,[["__scopeId","data-v-f68cd205"]]);export{T as default};