'use strict';var wasmImports = {
native:{
setConsoleErrorString:v => console.error(v),
getDocumentCreateElement2:n => document.createElement(n),
setString:v => { const l = []; for (let a of v[2]) { l.push(String.fromCharCode(a)); } return l.join(''); },
setHtmlElementInnerText:(o, v) => o.innerText = v,
getDocument:() => document,
getHtmlBodyElement:o => o.body,
setHtmlElementAppend:(o, c) => o.append(c),
setHtmlElementAttribute:(e, n, v) => e.setAttribute(n, v)
},
NonGC:{
array_new_u16:(l)=>Object.seal({0:676,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_StringBuilder:() => Object.seal({0:868,1:0,2:null,3:0}),
new_java_util_Collections$EmptySet:() => Object.seal({0:2396,1:0}),
new_java_util_Collections$UnmodifiableList:() => Object.seal({0:2068,1:0,2:null,3:null}),
new_java_lang_OutOfMemoryError:() => Object.seal({0:1276,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_ThreadLocal:() => Object.seal({0:1700,1:0,2:0}),
new_org_application_web_widgets_Widget:() => Object.seal({0:432,1:0,2:null}),
new_java_util_concurrent_atomic_AtomicInteger:() => Object.seal({0:2204,1:0,2:0}),
get_i32:(a,i) => a[i],
array_new_i32:(l)=>Object.seal({0:780,1:0,2:new Int32Array(l)}),
new_org_application_web_views_Desktop:() => Object.seal({0:296,1:0}),
new_java_lang_StringIndexOutOfBoundsException:() => Object.seal({0:812,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_NullPointerException:() => Object.seal({0:2344,1:0,2:null,3:null,4:null,5:null}),
new_org_application_web_elements_Body:() => Object.seal({0:356,1:0,2:null}),
ref_eq:(a,b) => a === b,
new_java_lang_IllegalArgumentException:() => Object.seal({0:1128,1:0,2:null,3:null,4:null,5:null}),
get_anyref:(a,i) => a[i],
array_new_java_lang_StackTraceElement:(l)=>Object.seal({0:1212,1:0,2:Object.seal(new Array(l).fill(null))}),
set_anyref:(a,v,i) => a[i]=v,
array_get_i32:(a,i)=>a[2][i],
new_java_lang_String:() => Object.seal({0:504,1:0,2:null,3:0}),
get_externref:(a,i) => a[i],
new_java_util_Collections$UnmodifiableRandomAccessList:() => Object.seal({0:2016,1:0,2:null,3:null}),
array_new_java_lang_Throwable:(l)=>Object.seal({0:1668,1:0,2:Object.seal(new Array(l).fill(null))}),
array_set_i32:(a,i,v)=>a[2][i]=v,
new_java_lang_AssertionError:() => Object.seal({0:2112,1:0,2:null,3:null,4:null,5:null}),
array_new_java_io_ObjectStreamField:(l)=>Object.seal({0:1484,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_String$CaseInsensitiveComparator:() => Object.seal({0:1516,1:0}),
new_java_util_Collections$EmptyMap:() => Object.seal({0:2560,1:0}),
array_new_i8:(l)=>Object.seal({0:604,1:0,2:new Uint8Array(l)}),
array_len:(a)=>a[2].length,
new_java_util_ArrayList:() => Object.seal({0:1616,1:0,2:0,3:null}),
new_java_lang_Class:() => Object.seal({0:1580,1:0,2:0,3:0}),
new_java_util_Collections$EmptyList:() => Object.seal({0:2476,1:0,2:0}),
set_i32:(a,v,i) => a[i]=v,
array_new_java_lang_Object:(l)=>Object.seal({0:1956,1:0,2:Object.seal(new Array(l).fill(null))})
},
System:{
arraycopy:(src,srcPos,dest,destPos,length)=>{src=src[2];dest=dest[2];if(destPos<srcPos){for (var i=0;i<length;i++)dest[i+destPos]=src[i+srcPos];}else{for (var i=length-1;i>=0;i--)dest[i+destPos]=src[i+srcPos];}}
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;