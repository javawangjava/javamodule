public class VueNotes {


/*
*
* Vue 是一套前端框架，免除原生JavaScript中的DOM操作，简化书写。
*       双向绑定是指当模型数据发生变化时，页面展示的会随之发生变化，而如果表单数据发生变化，绑定的模型数据也随之发生变化。
*       VUE 是如何简化 DOM 书写:基于MVVM(Model-View-ViewModel)思想，实现数据的双向绑定，将编程的关注点放在数据上。
*               Model 是数据;
*               View 是视图，也就是页面标签，用户可以通过浏览器看到的内容;
*               Model 和 View 是通过 ViewModel 对象进行双向绑定的，而 ViewModel 对象是 Vue 提供的。
*
*               使用Vue指令将html标签与Vue对象绑定起来，这样Vue对象【模型数据】就可以和html页面绑定起来了。
*       【vue使用步骤】
*               【步骤一】新建 HTML 页面，引入 Vue.js文件：<script src="js/vue.js"></script>；
*               【步骤二】在JS代码区域，创建Vue核心对象，进行数据绑定；
*                          new Vue({
*                                el: "#app",
*                                data() {
*                                    return {
*                                        返回的数据值
*                                    }
*                                },
*                                // methods属性表示事件绑定的方法，methods属性表示方法，在大括号在中定义方法
*                                methods: {
*                                    方法名() {
*                                        方法体
*                                    }
*                                }
*                            });
*                   创建 Vue 对象时，需要传递一个 js 对象，而该对象中需要如下属性：
*                       1.el ： 用来指定哪儿些标签受 Vue 管理； 该属性取值 #app 中的 app 是受管理的标签的id属性值；
*                       2.data ：用来定义数据模型；
*                       3.methods ：用来定义函数。
*
*               【步骤三】编写视图；
*
*
*    Vue 指令
*
*       Vue 指令（Directives）是 Vue.js 的一项核心功能，它们可以在 HTML 模板中以 v- 开头的特殊属性形式使用，用于将响应式数据绑定到 DOM 元素上或在 DOM 元素上进行一些操作。
*       Vue 指令：HTML 标签中带有前缀 v- 的特殊 HTML 属性，它赋予 HTML 标签额外的功能。
*
*       v-bind: 为HTML标签原有属性绑定模型数据【用于将 Vue 实例的数据绑定到 HTML 元素的属性上】。
*       v-model: 为HTML表单元素上创建双向数据绑定【用于在表单控件和 Vue 实例的数据之间创建双向数据绑定】;
*       v-on: 为HTML标签绑定事件【用于在 HTML 元素上绑定事件监听器，使其能够触发 Vue 实例中的方法或函数。】使用 v-on 时还可以使用简化的写法，将 v-on: 替换成 @ 。;
*       v-show: 根据条件展示某元素，区别在于切换的是display属性的值【用于根据表达式的值来条件性地显示或隐藏元素】;
*       v-if: 条件性的渲染某元素，判定为true时渲染,否则不渲染;
*       v-else
*       v-else-if
*       v-for: 列表渲染，遍历容器的元素或者对象的属性.
*
*
*   Vue 生命周期：只要掌握mounted就行了。
*       mounted ：挂载完成，Vue初始化成功，HTML页面渲染成功。而以后我们会在该方法中发送异步请求，加载数据。
*       生命周期的八个阶段：每触发一个生命周期事件，会自动执行一个生命周期方法，这些生命周期方法也被称为钩子方法。
*           beforeCreate:创建前
*           created:创健后
*           beforeMount:载入前
*           mounted:挂载完成
*           beforeUpdate:更新前
*           updated:更新后
*           beforeDestrov:销毁前
*           destroyed:销毁后
*
*
*
* */

}
