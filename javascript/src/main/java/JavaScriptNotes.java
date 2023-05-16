public class JavaScriptNotes {


/**
*
* Java语言也是跨平台的、面向对象的语言，Java是编译语言，是需要编译成字节码文件才能运行的.
*
* JavaScript：JavaScript简称JS(js)
*       面向对象的脚本语言。注意面向对象，所以对于对象的属性和方法调用时需要主调，若主调是window对象，则window.可以省略【也就是window对象的属性和方法可以直接访问】。
*       JavaScript 是一门跨平台、面向对象的脚本语言，JavaScript是脚本语言，不需要编译，由浏览器直接解析并执行。
*       JavaScript 是用来控制网页行为的，它能使网页可交互.
*       JavaScript 和 Java 是完全不同的语言，不论是概念还是设计，只是名字比较像而已。但是基础语法类似.
*       JavaScript（简称：JS） 在 1995 年由 Brendan Eich 发明，并于 1997 年成为一部 ECMA 标准。ECMA 规定了一套标准 就叫ECMAScript ，所有的客户端校验语言必须遵守这个标准，当然 JavaScript 也遵守了这个标准。
*       ECMAScript 6 (简称ES6) 是最新的 JavaScript 版本（发布于 2015 年)，我们的课程就是基于最新的 ES6 进行讲解。
*
*
*   JavaScript 引入方式：在HTML文件中使用<script>标签引入的就是JavaScript脚本语言。
*       JavaScript 引入方式就是 HTML 和 JavaScript 的结合方式。JavaScript引入方式有两种：
*               在符合语法规则的前提下，在 HTML 文档中可以在任意地方，放置任意数量的标签。
*               script放置位置的原则“页面效果实现类的js应该放在body之前，动作，交互，事件驱动，需要访问dom属性的js都可以放在body之后”。
*                   因为浏览器在加载页面的时候会从上往下进行加载并解析。 我们应该让用户看到页面内容，然后再展示动态的效果。
*               <script>标签是使用在html页面【文件】中，所以不能在外部脚本文件【外部脚本文件的类型是(.js)类型的】中使用。
*               在外部js文件【(.js)文件的内部】直接写js代码就可以。
*               <script>标签不能自闭和，也就是<script>标签必须成对出现。
*
*
*                   JavaScript 引入方式引入方式一：内部脚本：将 JS代码定义在HTML文件的<script>js代码</script>两个标签中；
*                   JavaScript 引入方式引入方式二：外部脚本：将 JS代码定义在外部 JS文件中，然后使用<script></script>的src属性引入到 HTML页面中【在页面使用 script标签中使用 src 属性指定 js 文件的 URL 路径】。
*
*                   内部脚本:在 HTML文件中，JavaScript 代码必须位于 <script> 与 </script> 标签之间。
*                   外部脚本:【步骤一】定义外部js文件；【步骤二】在html页面中使用<script>标签的src属性将外部js文件引入到HTML页面中【在页面使用 script 标签中使用 src 属性指定 js 文件的 URL 路径】。
*
*
*       JavaScript 语法：
*               js书写语法：
*                   区分大小写；
*                   每行结尾的分号可有可无，如果一行上写多个语句时，必须加分号用来区分多个语句。
*                   注释：单行注释：// 注释内容；多行注释：/* 注释内容 *()/ 。注意多行注释没有最后那个斜杠前面的小括号，这里只是为了方便写进注释中；注意：JavaScript 没有文档注释。
*                   大括号表示代码块；
*
*
*               js输出语句：
*                   使用 window.alert() 显示带有消息和确定按钮的警报框（对话框）【写入警告框】。
*                   使用 document.write() 写入 HTML 输出【是将内容写出到网页页面】；
*                   使用 document.writeln() 与 write() 相同，但在每条语句后添加换行符。；
*                   使用 console.log() 写入浏览器控制台；
 *                  在JS中进行换行输出：
 *                          方法一：使用“\n”进行换行；
 *                          方法二：使用“\r”进行换行；
 *                          方法三：使用<br/>进行换行【只适用于document.write()】。
 *                          注意：“\r”的用法跟“\n”一样，在document.write()中，只起到空格的作用。
 *
*
*
*               js变量：
*                   js 中的变量名命名规则和java语言基本都相同。
 *                  var 变量：
*                       JavaScript 中使用 var 关键字（variable 的缩写）来声明的变量。
 *                          格式 var 变量名 = 数据值; 。
*                       JavaScript 是一门弱类型语言，var变量可以存放不同类型的值【即可以给var变量赋予不同的值】；
*                       var声明的变量是全局变量；
 *                      var变量是可重复变量【即可以声明多个同名的var变量】。
 *
 *                  let 变量：
*                       ECMAScript 6 新增了 let 关键字来定义局部变量，只在let变量声明的代码块中有效，且不允许重复声明。
 *
*                   const 变量：
*                       ECMAScript 6 新增了 const关键字来定义常量。一旦声明，常量的值就不能改变。
*
*
*               js数据类型：
*                   JavaScript 中提供了两类数据类型：原始类型 和 引用类型。
*                   JavaScript 中使用 typeof 运算符可以获取数据类型。
*                   JavaScript 中原始类型：
*                       number：数字(整数、小数、NaN(Not a Number))；
*                       string：字符、字符串，在 js 中双引号和单引号都表示字符串类型的数据；
*                       boolean：布尔。true，false;
*                       null：对象为空;如果判断其类型的话，就是object；
*                       undefined：当声明的变量未初始化时，该变量的默认值是 undefined;
*
*
*               js运算符：
*                   JavaScript 中大部分运算符和 Java语言都是一样的，不同的是 JS 关系运算符中的 == 和 ===。
*                       ==：【==只要求数值大小一样，不考虑类型】1. 判断类型是否一样，如果不一样，则进行类型转换；2. 再去比较其值。
*                       ===：【===要类型和值两个都一样】js 中的全等于。1. 判断类型是否一样，如果不一样，直接返回false；2. 再去比较其值。
*
*
*               js变量类型转换：
*                   在 Java 中使用字符串前，一般都会先判断字符串不是null，并且不是空字符才会做其他的一些操作，JavaScript也有类型的操作。
*                   但是由于 JavaScript 会自动进行类型转换，所以字符串判断可以进行简化。
*                   其他类型转为number：
*                       string 转换为 number 类型：按照字符串的字面值，转为数字。如果字面值不是数字，则转为NaN；将 string 转换为 number 有两种方式：
*                           将 string 转换为 number 方式一：使用 + 正号运算符；
*                           将 string 转换为 number 方式二【推荐使用】：使用 parseInt() 函数【方法】；
*                       boolean 转换为 number 类型：true 转为1，false转为0。
*                   其他类型转为boolean：
*                       number 类型转换为 boolean 类型：0和NaN转为false，其他的数字转为true；
*                       string 类型转换为 boolean 类型：空字符串转为false，其他的字符串转为true；
*                       null类型转换为 boolean 类型是 false；
*                       undefined 转换为 boolean 类型是 false；
*
*
*               js流程控制语句：
*                   JavaScript 中提供了和 Java 一样的流程控制语句。
*
*
*               js函数：
*                   js函数（就是Java中的方法）是被设计为执行特定任务的代码块；JavaScript 函数通过 function 关键词进行定义。
*                   js函数形式参数不需要类型，只要写出形参名就可以。因为JavaScript是弱类型语言;
*                   js函数返回值也不需要定义类型，可以在函数内部直接使用return返回即可;
*                   js函数调用：函数名(实际参数列表)；
*                   js函数调用可以传递任意个参数，如果实参个数多余形参个数，则多余的实参不会匹配；
*                   js函数定义方式有两种：
*                       js函数定义方式一：function 函数名([参数1，参数2...]){要执行的代码}
*                       js函数定义方式二：var 函数名=function ([参数1，参数2...]){要执行的代码}
*
*                   js是面向对象的语言，所以对于对象的成员变量和成员方法的调用需要主调。
*                       js函数调用：对象.function(实际参数列表)。没有写主调就默认主调是window对象，window.省略了。
*
*
 *
 *       对于 JavaScript 中对象的使用要查文档：https://www.w3school.com.cn或者https://www.rookiew.com/。
 *
*              JavaScript常用对象:其实就是类似Java中的对象
*                   Array对象：Array对象的属性和方法查看手册。https://www.w3school.com.cn或者https://www.rookiew.com/
*                           Array对象用于定义数组:
*                               数组定义方式一：var 变量名 = new Array(元素列表);
*                               数组定义方式二：var 变量名 = [元素列表];
*                           Array对象元素访问：访问数组中的元素和 Java 语言的一样；
*                           JS 中的数组相当于 Java 中集合。数组的长度是可以变化的，而且 JS是弱类型，所以可以存储任意的类型的数据；
*                           Array对象有length属性：arr.length表示数组长度；
*
*                    String对象:创建方式和Java一样。
*                           String对象的属性和方法查看手册。https://www.w3school.com.cn或者https://www.rookiew.com/
*
*                    自定义对象：自定义对象格式
*                           var 对象名称={
 *                               属性名称1：属性值1，
 *                               属性名称2：属性值2，
 *                               ...，
 *                               函数名称：function(形参列表){}，
 *                               ...
 *                           }
*                           自定义对象属性的调用：对象名.属性名；
*                           自定义对象方法的调用：对象名.函数名(实参列表)；
*                           String对象的属性和方法查看手册。https://www.w3school.com.cn或者https://www.rookiew.com/
*
 *
 *
 *              JavaScript中BOM(浏览器对象模型)  使用的时候参看手册：https://www.w3school.com.cn或者https://www.rookiew.com/
 *                      BOM：Browser Object Model 浏览器对象模型【对象模型中包含着对象】。也就是 JavaScript 将浏览器的各个组成部分封装为对象。
 *                      如果要操作浏览器的各个组成部分就可以通过操作 BOM 中的对象来实现。
 *                      BOM(浏览器对象模型)中包含了如下对象:
 *                          Navigator：浏览器对象【很少使用】；
 *                          Screen：显示器屏幕对象【很少使用】；
 *                          Window：浏览器窗口对象【window 对象是 JavaScript 对浏览器的窗口进行封装的对象。】；
 *                          History：浏览器的历史记录对象；
 *                          Location：浏览器地址栏对象【地址栏就是填网站的那个地方】；
 *
 *                      Window对象
 *                          window 对象是 JavaScript 对浏览器的窗口进行封装的对象。
 *                          window 对象不需要创建直接使用 window ，其中 window. 可以省略。
 *                          window 对象提供了用于获取其他 BOM 组成对象的属性。
 *                              例如也就是说，我们想使用 Location 对象的话，就可以使用 window 对象获取；写成 window.location ，而 window. 可以省略，简化写成 location 来获取 Location 对象。
 *                          Window对象常用的函数：
 *                              alert()：显示带有一段消息和一个确认按钮的警告框。
 *                              confirm()：显示带有一段消息以及确认按钮和取消按钮的对话框。点击确认按钮，返回true,点击取消按钮，返回false。
 *                              setInterval()：按照指定的周期（以毫秒计）来调用函数或计算表达式。
 *                              setTimeout()：在指定的毫秒数后调用函数或计算表达式。
 *                                  setInterval(function,毫秒值):在一定的时间间隔后执行一个function，循环执行。
 *                                  setTimeout(function,毫秒值) : 在一定的时间间隔后执行一个function，只执行一次；
 *
 *
 *                      History对象
 *                          History 对象是 JavaScript 对历史记录进行封装的对象。
 *                          History 对象的获取：使用 window.history获取，其中window. 可以省略。
 *                          History 对象的函数：
 *                              back()：加载 history 列表中的前一个 URL【当我们点击向左的箭头，就跳转到前一个访问的页面，这就是 back() 函数的作用】；
 *                              forward()：加载 history 列表中的下一个 URL【当我们点击向右的箭头，就跳转到下一个访问的页面，这就是 forward() 函数的作用。】；
 *                              go()：加载 history 列表中的某个具体页面；
 *
 *                      Location对象
 *                          Location 对象是 JavaScript 对地址栏封装的对象。可以通过操作该对象，跳转到任意页面。
 *                          Location对象的获取：使用 window.location获取，其中window. 可以省略。
 *                          Location对象的常用属性：
 *                              href：返回完整的URL。
 *
 *
 *     DOM相关概念：
 *          DOM 是 W3C（万维网联盟）定义了访问 HTML 和 XML 文档的标准。该标准被分为 3 个不同的部分：
 *              1. 核心 DOM：针对任何结构化文档的标准模型。 XML 和 HTML 通用的标准；
 *                      Document：整个文档对象；
 *                      Element：元素对象；
 *                      Attribute：属性对象；
 *                      Text：文本对象；
 *                      Comment：注释对象；
 *              2. XML DOM： 针对 XML 文档的标准模型； XML 文档中的标签需要我们写代码解析。
 *              3. HTML DOM： 针对 HTML 文档的标准模型；
 *                      该标准是在核心 DOM 基础上，对 HTML 中的每个标签都封装成了不同的对象；也就是HTML的每一个标签都会被包装成标签表示的对象，也会被包装成Element对象。
 *                          例如： <img> 标签在浏览器加载到内存中时会被封装成 Image 对象，同时该对象也是 Element 对象；
 *                          例如： <input type='button'> 标签在浏览器加载到内存中时会被封装成 Button 对象，同时该对象也是Element 对象。
 *
 *
 *              JavaScript中DOM(文档对象模型)  使用的时候参看手册：https://www.w3school.com.cn或者https://www.rookiew.com/
 *                      DOM：Document Object Model 文档对象模型。也就是 JavaScript 将 HTML 文档的各个组成部分封装为对象。
 *
 *                      DOM(文档对象模型)封装的对象分为：
 *                              Document：整个文档对象；
 *                              Element：元素对象；
 *                              Attribute：属性对象；
 *                              Text：文本对象；
 *                              Comment：注释对象。
 *
 *                      Document对象：整个文档对象；
 *                           Document对象获取：使用 window.document获取，其中window. 可以省略。
 *                                  也就是document对象可以直接使用。
 *
 *                           Document 对象属性和方法：
 *                                  document.getElementsByClassName()：根据class属性值获取，返回Element对象数组【JS中数组就是Java中集合】；【返回文档中所有指定类名的元素集合，作为 NodeList 对象。】
 *                                  document.getElementById()：根据id属性值获取，返回单个Element对象；【返回对拥有指定 id 的第一个对象的引用。】
 *                                  document.getElementsByName()：根据name属性值获取，返回Element对象数组；【返回带有指定名称的对象集合。】
 *                                  document.getElementsByTagName()：根据标签名称获取，返回Element对象数组；【返回带有指定标签名的对象集合。】
 *
 *
 *                      Element对象:元素对象；
 *                           JavaScript 将 HTML 中的每个标签都封装成了不同的对象，也就是HTML中每一个标签都是JS中Element对象。
 *                           Element对象获取：HTML 中的 Element 对象可以通过 Document 对象获取，使用 document.获取；
 *                           Document 对象中提供了以下获取 Element 元素对象的函数：
 *                                  document.getElementsByClassName()：根据class属性值获取，返回Element对象数组【JS中数组就是Java中集合】；【返回文档中所有指定类名的元素集合，作为 NodeList 对象。】
 *                                  document.getElementById()：根据id属性值获取，返回单个Element对象；【返回对拥有指定 id 的第一个对象的引用。】
 *                                  document.getElementsByName()：根据name属性值获取，返回Element对象数组；【返回带有指定名称的对象集合。】
 *                                  document.getElementsByTagName()：根据标签名称【标签名称就是HTML文档中<>表示的哪一个】获取，返回Element对象数组；【返回带有指定标签名的对象集合。】
 *
 *                           HTML Element对象使用：
 *                                  HTML 中的 Element 元素对象有很多，不可能全部记住，以后是根据具体的需求查阅文档使用。
 *
 *
 *
 *              JavaScript 事件
 *                      HTML 事件是发生在 HTML 元素上的“事情”。比如：页面上的 按钮被点击、 鼠标移动到元素之上、 按下键盘按键 等都是事件。
 *                      所以先要给某一个html元素赋予某种事件属性【其实就是对html元素进行了什么操作】，该html元素被操作之后，对应采取的措施。【就是当某元素发生某事件时，需要一个对应的函数】
 *                          onmouseover:鼠标被移到某元素之上
 *                          onmouseout:鼠标从某元素移开
 *                          onclick:鼠标单击事件
 *                          onblur:元素失去焦点
 *                          onfocus:元素获得焦点
 *                          onload:某个页面或图像被完成加载
 *                          onsubmit:当表单提交时触发该事件
 *
 *
 *              JavaScript 事件绑定就是将一个函数赋值给一个元素的事件
 *                  HTML事件是发生在 HTML 元素上的“事情”。比如：页面上的按钮被点击、 鼠标移动到元素之上、 按下键盘按键等都是事件。
 *                  要想让 JavaScript 对用户的操作作出响应，首先要对 DOM 元素绑定事件处理函数。
 *                  所谓事件处理函数，就是处理用户操作的函数，不同的操作对应不同的名称。
 *                  在JavaScript中，有三种常用的绑定事件的方法：
 *                          JavaScript 事件绑定方式一：在DOM元素中直接绑定【在 HTML标签中使用事件属性进行绑定】；
 *                                  【步骤一】：在html标签中通过标签的属性来绑定一个函数func；
 *                                  【步骤二】：在<script>标签定义在标签属性中定义的函数func。
 *                          JavaScript 事件绑定方式二：在JavaScript代码中使用DOM属性进行绑定；【推荐使用】
 *                                  在<script>标签的JS代码中获取事件需要绑定的DOM元素，给DOM元素的某一个事件属性绑定一个函数。
 *                                  这个函数就是对该元素发生某一个事件做出的对应处理。
 *                          JavaScript 事件绑定方式三：绑定事件监听函数。
 *
 *
 *
 *
 *          正则表达式
 *              正则表达式（英语：Regular Expression，在代码中常简写为regex、regexp或RE）使用单个字符串来描述、匹配一系列符合某个句法规则的字符串搜索模式。
 *              正则表达式定义了字符串组成的规则。也就是判断指定的字符串是否符合指定的规则，如果符合返回true，如果不符合返回false。
 *              正则表达式是和语言无关的。很多语言都支持正则表达式，Java语言也支持，只不过正则表达式在不同的语言中的使用方式不同，js 中需要使用正则对象来使用正则表达式。
 *                  JS中正则表达式常用的规则如下：
 *                      • ^：表示开始
 *                      • $：表示结束
 *                      • [ ]：代表方括号之间的单个字符，比如： [0-9] 查找任何从 0 至 9 的数字.
 *                      • .：代表任意单个字符，除了换行和行结束符
 *                      • \w：代表单词字符：字母、数字、下划线(_)，相当于 [A-Za-z0-9_]
 *                      • \d：代表数字字符： 相当于 [0-9]
 *                      • +：至少一个
 *                      • *：零个或多个
 *                      • ？：零个或一个
 *                      • {x}：x个
 *                      • {m,}：至少m个
 *                      • {m,n}：至少m个，最多n个
 *                      • i:执行对大小写不敏感的匹配。
 *                      • g:执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）。
 *                      • m:执行多行匹配。
 *
 *
 *
 *          RegExp对象(正则对象)
 *              RegExp 是正则对象。正则对象是用来判断指定字符串是否符合规则。在 js 中对正则表达式封装的对象就是正则对象。
 *              正则对象的使用
 *                  创建正则对象：创建正则对象语法格式
 *                      方式一：直接量：注意不要加引号：var reg = /正则表达式/修饰符(可选);
 *                      方式二：创建 RegExp 对象：var reg = new RegExp("正则表达式");
 *
 *                  正则对象的常用函数：
 *                      test(str)：判断指定字符串是否符合规则，返回 true或 false。
 *                      replace() ：replace() 方法用于在字符串中用一些字符串替换另一些字符串，或替换一个与正则表达式匹配的子串。
 *                      search() ：search() 方法用于检索字符串中指定的子字符串，或检索与正则表达式相匹配的子字符串，并返回子串的起始位置。
 *
 *
 *
 *
* */


}
