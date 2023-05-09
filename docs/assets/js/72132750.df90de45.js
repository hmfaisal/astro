"use strict";(self.webpackChunkastro_docs=self.webpackChunkastro_docs||[]).push([[245],{3905:(e,t,n)=>{n.d(t,{Zo:()=>u,kt:()=>f});var i=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function r(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var i=Object.getOwnPropertySymbols(e);t&&(i=i.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,i)}return n}function o(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?r(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function l(e,t){if(null==e)return{};var n,i,a=function(e,t){if(null==e)return{};var n,i,a={},r=Object.keys(e);for(i=0;i<r.length;i++)n=r[i],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);for(i=0;i<r.length;i++)n=r[i],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var s=i.createContext({}),c=function(e){var t=i.useContext(s),n=t;return e&&(n="function"==typeof e?e(t):o(o({},t),e)),n},u=function(e){var t=c(e.components);return i.createElement(s.Provider,{value:t},e.children)},p="mdxType",d={inlineCode:"code",wrapper:function(e){var t=e.children;return i.createElement(i.Fragment,{},t)}},m=i.forwardRef((function(e,t){var n=e.components,a=e.mdxType,r=e.originalType,s=e.parentName,u=l(e,["components","mdxType","originalType","parentName"]),p=c(n),m=a,f=p["".concat(s,".").concat(m)]||p[m]||d[m]||r;return n?i.createElement(f,o(o({ref:t},u),{},{components:n})):i.createElement(f,o({ref:t},u))}));function f(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var r=n.length,o=new Array(r);o[0]=m;var l={};for(var s in t)hasOwnProperty.call(t,s)&&(l[s]=t[s]);l.originalType=e,l[p]="string"==typeof e?e:a,o[1]=l;for(var c=2;c<r;c++)o[c]=n[c];return i.createElement.apply(null,o)}return i.createElement.apply(null,n)}m.displayName="MDXCreateElement"},816:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>s,contentTitle:()=>o,default:()=>d,frontMatter:()=>r,metadata:()=>l,toc:()=>c});var i=n(7462),a=(n(7294),n(3905));const r={sidebar_position:2},o="Activity Entry",l={unversionedId:"ui-related/main-activity",id:"ui-related/main-activity",title:"Activity Entry",description:"MainActivity",source:"@site/docs/ui-related/main-activity.md",sourceDirName:"ui-related",slug:"/ui-related/main-activity",permalink:"/astro/docs/ui-related/main-activity",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/ui-related/main-activity.md",tags:[],version:"current",sidebarPosition:2,frontMatter:{sidebar_position:2},sidebar:"tutorialSidebar",previous:{title:"Application Entry",permalink:"/astro/docs/ui-related/main-application"},next:{title:"UI Screens",permalink:"/astro/docs/ui-related/screens"}},s={},c=[{value:"MainActivity",id:"mainactivity",level:2},{value:"MainView",id:"mainview",level:2},{value:"Navigation",id:"navigation",level:2}],u={toc:c},p="wrapper";function d(e){let{components:t,...n}=e;return(0,a.kt)(p,(0,i.Z)({},u,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("h1",{id:"activity-entry"},"Activity Entry"),(0,a.kt)("h2",{id:"mainactivity"},"MainActivity"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},"This is the main entry point of application. "),(0,a.kt)("li",{parentName:"ul"},"In the ",(0,a.kt)("inlineCode",{parentName:"li"},"onCreate")," method, the ",(0,a.kt)("inlineCode",{parentName:"li"},"setContent")," function is called to set the content of the activity to a Composable function defined as ",(0,a.kt)("inlineCode",{parentName:"li"},"MainView"),". "),(0,a.kt)("li",{parentName:"ul"},"The ",(0,a.kt)("inlineCode",{parentName:"li"},"AstroTheme")," is applied as the parent theme for the content. Inside the AstroTheme, a Surface composable is used as a container with the background color defined by the ",(0,a.kt)("inlineCode",{parentName:"li"},"MaterialTheme"),".")),(0,a.kt)("h2",{id:"mainview"},"MainView"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},"This function defines the UI of the main screen. "),(0,a.kt)("li",{parentName:"ul"},"It creates a navController using the ",(0,a.kt)("inlineCode",{parentName:"li"},"rememberNavController")," function (used to remember the NavController across configuration changes, such as screen rotations, so that the user's place in the navigation stack is preserved.), which is responsible for handling navigation within the app. "),(0,a.kt)("li",{parentName:"ul"},"It also creates an instance of ",(0,a.kt)("inlineCode",{parentName:"li"},"AstronautListViewModel")," using the ",(0,a.kt)("inlineCode",{parentName:"li"},"viewModel")," function, which is used to provide data to the screens. "),(0,a.kt)("li",{parentName:"ul"},"Inside the ",(0,a.kt)("inlineCode",{parentName:"li"},"NavHost")," composable, the different destinations/routes of the app are defined. The startDestination is set to ",(0,a.kt)("inlineCode",{parentName:"li"},"AstronautListScreen"),", which represents the initial screen of the app.")),(0,a.kt)("h2",{id:"navigation"},"Navigation"),(0,a.kt)("p",null,"The Navigation sealed class defines the available navigation routes in the app. It includes Astronauts and Astronaut, each represented by a unique route string."))}d.isMDXComponent=!0}}]);