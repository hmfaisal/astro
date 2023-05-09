"use strict";(self.webpackChunkastro_docs=self.webpackChunkastro_docs||[]).push([[940],{3905:(t,e,a)=>{a.d(e,{Zo:()=>c,kt:()=>m});var r=a(7294);function n(t,e,a){return e in t?Object.defineProperty(t,e,{value:a,enumerable:!0,configurable:!0,writable:!0}):t[e]=a,t}function o(t,e){var a=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),a.push.apply(a,r)}return a}function s(t){for(var e=1;e<arguments.length;e++){var a=null!=arguments[e]?arguments[e]:{};e%2?o(Object(a),!0).forEach((function(e){n(t,e,a[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(a)):o(Object(a)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(a,e))}))}return t}function i(t,e){if(null==t)return{};var a,r,n=function(t,e){if(null==t)return{};var a,r,n={},o=Object.keys(t);for(r=0;r<o.length;r++)a=o[r],e.indexOf(a)>=0||(n[a]=t[a]);return n}(t,e);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(t);for(r=0;r<o.length;r++)a=o[r],e.indexOf(a)>=0||Object.prototype.propertyIsEnumerable.call(t,a)&&(n[a]=t[a])}return n}var l=r.createContext({}),u=function(t){var e=r.useContext(l),a=e;return t&&(a="function"==typeof t?t(e):s(s({},e),t)),a},c=function(t){var e=u(t.components);return r.createElement(l.Provider,{value:e},t.children)},p="mdxType",d={inlineCode:"code",wrapper:function(t){var e=t.children;return r.createElement(r.Fragment,{},e)}},f=r.forwardRef((function(t,e){var a=t.components,n=t.mdxType,o=t.originalType,l=t.parentName,c=i(t,["components","mdxType","originalType","parentName"]),p=u(a),f=n,m=p["".concat(l,".").concat(f)]||p[f]||d[f]||o;return a?r.createElement(m,s(s({ref:e},c),{},{components:a})):r.createElement(m,s({ref:e},c))}));function m(t,e){var a=arguments,n=e&&e.mdxType;if("string"==typeof t||n){var o=a.length,s=new Array(o);s[0]=f;var i={};for(var l in e)hasOwnProperty.call(e,l)&&(i[l]=e[l]);i.originalType=t,i[p]="string"==typeof t?t:n,s[1]=i;for(var u=2;u<o;u++)s[u]=a[u];return r.createElement.apply(null,s)}return r.createElement.apply(null,a)}f.displayName="MDXCreateElement"},8408:(t,e,a)=>{a.r(e),a.d(e,{assets:()=>l,contentTitle:()=>s,default:()=>d,frontMatter:()=>o,metadata:()=>i,toc:()=>u});var r=a(7462),n=(a(7294),a(3905));const o={sidebar_position:3},s="Local Data",i={unversionedId:"data-related/local-data-part",id:"data-related/local-data-part",title:"Local Data",description:"AstronautEntity",source:"@site/docs/data-related/local-data-part.md",sourceDirName:"data-related",slug:"/data-related/local-data-part",permalink:"/astro/docs/data-related/local-data-part",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/data-related/local-data-part.md",tags:[],version:"current",sidebarPosition:3,frontMatter:{sidebar_position:3},sidebar:"tutorialSidebar",previous:{title:"Remote Data",permalink:"/astro/docs/data-related/remote-data-part"},next:{title:"Data Mapping",permalink:"/astro/docs/data-related/data-mapper"}},l={},u=[{value:"AstronautEntity",id:"astronautentity",level:2},{value:"AstronautDao",id:"astronautdao",level:2},{value:"AstronautDatabase",id:"astronautdatabase",level:2}],c={toc:u},p="wrapper";function d(t){let{components:e,...a}=t;return(0,n.kt)(p,(0,r.Z)({},c,a,{components:e,mdxType:"MDXLayout"}),(0,n.kt)("h1",{id:"local-data"},"Local Data"),(0,n.kt)("h2",{id:"astronautentity"},"AstronautEntity"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},"Represents the entity version of the Astronaut data class, used for the local database."),(0,n.kt)("li",{parentName:"ul"},"It has properties similar to Astronaut, but with annotations such as @PrimaryKey for specifying the primary key and @Entity for defining the table name.")),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-java"},'@Entity(tableName = "astronauts")\ndata class AstronautEntity(\n    @PrimaryKey\n    val id: Int,\n    val name: String,\n    val age: Int,\n    val bio: String,\n    val nationality: String,\n    val status: StatusEntity,\n    val flightsCount: Int?,\n    val flights: List<FlightEntity>?,\n    val profileImageUrl: String?,\n    val profileImageThumbnailUrl: String?\n)\n')),(0,n.kt)("h2",{id:"astronautdao"},"AstronautDao"),(0,n.kt)("p",null,'It defines various methods for performing database operations related to the "astronauts" table'),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},'This query method retrieves a list of AstronautEntity objects from the "astronauts" table.')),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-sqlite3"},'@Query("SELECT * FROM astronauts LIMIT :pageSize OFFSET (:page - 1) * :pageSize")\n')),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},'This insert method is used to insert a list of AstronautEntity objects into the "astronauts" table. It uses the onConflict parameter to specify the conflict resolution strategy, which is set to REPLACE to replace existing rows with the new ones.')),(0,n.kt)("pre",null,(0,n.kt)("code",{parentName:"pre",className:"language-sqlite3"},"@Insert(onConflict = OnConflictStrategy.REPLACE)\n")),(0,n.kt)("h2",{id:"astronautdatabase"},"AstronautDatabase"),(0,n.kt)("ul",null,(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("inlineCode",{parentName:"li"},"@Database(entities = [AstronautEntity::class], version = 1)"),' : It specifies the entities (database tables) that are part of the database. In this case, AstronautEntity is the entity class representing the "astronauts" table.'),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("inlineCode",{parentName:"li"},"@TypeConverters(Converters::class)")," : This annotation is used to specify the type converters used by the database. Type converters are used to convert custom data types (such as List, Date, etc.) to a format that can be stored in the database."),(0,n.kt)("li",{parentName:"ul"},(0,n.kt)("inlineCode",{parentName:"li"},"abstract fun astronautDao(): AstronautDao"),' : It returns an instance of the AstronautDao interface for performing database operations related to the "astronauts" table.')))}d.isMDXComponent=!0}}]);