"use strict";(self.webpackChunkastro_docs=self.webpackChunkastro_docs||[]).push([[255],{3905:(t,e,a)=>{a.d(e,{Zo:()=>c,kt:()=>m});var r=a(7294);function n(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function o(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,r)}return a}function i(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?o(Object(a),!0).forEach((function(e){n(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):o(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}function s(t,e){if(null==t)return{};var a,r,n=function(t,e){if(null==t)return{};var a,r,n={},o=Object.keys(t);for(r=0;r<o.length;r++)a=o[r],e.indexOf(a)>=0||(n[a]=t[a]);return n}(t,e);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);for(r=0;r<o.length;r++)a=o[r],e.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(t,a)&&(n[a]=t[a])}return n}var l=r.createContext({}),p=function(t){var e=r.useContext(l),a=e;return t&&(a="function"==typeof t?t(e):i(i({},e),t)),a},c=function(t){var e=p(t.components);return r.createElement(l.Provider,{value:e},t.children)},u="mdxType",d={inlineCode:"code",wrapper:function(t){var e=t.children;return r.createElement(r.Fragment,{},e)}},f=r.forwardRef((function(t,e){var a=t.components,n=t.mdxType,o=t.originalType,l=t.parentName,c=s(t,["components","mdxType","originalType","parentName"]),u=p(a),f=n,m=u["".concat(l,".").concat(f)]||u[f]||d[f]||o;return a?r.createElement(m,i(i({ref:e},c),{},{components:a})):r.createElement(m,i({ref:e},c))}));function m(t,e){var a=arguments,n=e&&e.mdxType;if("string"==typeof t||n){var o=a.length,i=new Array(o);i[0]=f;var s={};for(var l in e)hasOwnProperty.call(e,l)&&(s[l]=e[l]);s.originalType=t,s[u]="string"==typeof t?t:n,i[1]=s;for(var p=2;p<o;p++)i[p]=a[p];return r.createElement.apply(null,i)}return r.createElement.apply(null,a)}f.displayName="MDXCreateElement"},1888:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>l,contentTitle:()=>i,default:()=>d,frontMatter:()=>o,metadata:()=>s,toc:()=>p});var r=a(7462),n=(a(7294),a(3905));const o={sidebar_position:1},i="App Data",s={unversionedId:"data-related/app-data-part",id:"data-related/app-data-part",title:"App Data",description:"We will start by creating our App wise data class which we will use throught the app. Astronaut data class represents an astronaut with various properties.",source:"@site/docs/data-related/app-data-part.md",sourceDirName:"data-related",slug:"/data-related/app-data-part",permalink:"/data-related/app-data-part",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/data-related/app-data-part.md",tags:[],version:"current",sidebarPosition:1,frontMatter:{sidebar_position:1},sidebar:"tutorialSidebar",previous:{title:"Data Related Part",permalink:"/category/data-related-part"},next:{title:"Remote Data",permalink:"/data-related/remote-data-part"}},l={},p=[],c={toc:p},u="wrapper";function d(t){let{components:e,...a}=t;return(0,n.kt)(u,(0,r.Z)({},c,a,{components:e,mdxType:"MDXLayout"}),(0,n.kt)("h1",{id:"app-data"},"App Data"),(0,n.kt)("p",null,"We will start by creating our App wise data class which we will use throught the app. Astronaut data class represents an astronaut with various properties."),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},"data class Astronaut(\n    val id: Int,\n    val name: String,\n    val age: Int,\n    val bio: String,\n    val nationality: String,\n    val status: Status,\n    val flightsCount: Int?,\n    val flights: List<Flight>?,\n    val profileImageUrl: String?,\n    val profileImageThumbnailUrl: String?\n)\n")),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"The status property is of type Status, which is another data class representing the status of the astronaut."),(0,n.kt)("li",{parentName:"ul"},"The flights property is a list of Flight objects, which is another data class representing the flights the astronaut has been on.")))}d.isMDXComponent=!0}}]);