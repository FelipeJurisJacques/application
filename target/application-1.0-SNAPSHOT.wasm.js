'use strict';var wasmImports = {
native:{
setConsoleErrorString:v => console.error(v.asciiToString()),
getDocumentCreateElement1:n => document.createElement(String.fromCharCode(n)),
setConsoleLogString:v => console.log(v.asciiToString()),
setHtmlElementInnerText:(o, v) => o.innerText = v.asciiToString(),
getDocument:() => document,
getHtmlBodyElement:o => o.body,
setHtmlElementAppend:(o, c) => o.append(c),
setHtmlElementAttribute:(e, n, v) => e.setAttribute(n.asciiToString(), v.asciiToString())
},
NonGC:{
new_java_lang_StringBuilder:() => Object.seal({0:536,1:0,2:null,3:0}),
array_new_u16:(l)=>Object.seal({0:640,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_util_Collections$EmptySet:() => Object.seal({0:2328,1:0}),
new_java_util_Collections$UnmodifiableList:() => Object.seal({0:2000,1:0,2:null,3:null}),
new_java_lang_OutOfMemoryError:() => Object.seal({0:1064,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_ThreadLocal:() => Object.seal({0:1664,1:0,2:0}),
new_java_util_concurrent_atomic_AtomicInteger:() => Object.seal({0:2136,1:0,2:0}),
get_i32:(a,i) => a[i],
array_new_i32:(l)=>Object.seal({0:816,1:0,2:new Int32Array(l)}),
new_java_lang_StringIndexOutOfBoundsException:() => Object.seal({0:728,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_NullPointerException:() => Object.seal({0:2276,1:0,2:null,3:null,4:null,5:null}),
new_org_application_web_elements_Body:() => Object.seal({0:308,1:0,2:null}),
ref_eq:(a,b) => a === b,
new_java_lang_IllegalArgumentException:() => Object.seal({0:888,1:0,2:null,3:null,4:null,5:null}),
get_anyref:(a,i) => a[i],
new_org_application_web_elements_Paragraph:() => Object.seal({0:252,1:0,2:null}),
array_new_java_lang_StackTraceElement:(l)=>Object.seal({0:1244,1:0,2:Object.seal(new Array(l).fill(null))}),
set_anyref:(a,v,i) => a[i]=v,
array_get_i32:(a,i)=>a[2][i],
new_java_lang_String:() => Object.seal({0:364,1:0,2:null,3:0}),
get_externref:(a,i) => a[i],
new_java_util_Collections$UnmodifiableRandomAccessList:() => Object.seal({0:1948,1:0,2:null,3:null}),
array_new_java_lang_Throwable:(l)=>Object.seal({0:1632,1:0,2:Object.seal(new Array(l).fill(null))}),
array_set_i32:(a,i,v)=>a[2][i]=v,
new_java_lang_AssertionError:() => Object.seal({0:2044,1:0,2:null,3:null,4:null,5:null}),
array_new_java_io_ObjectStreamField:(l)=>Object.seal({0:1416,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_String$CaseInsensitiveComparator:() => Object.seal({0:1448,1:0}),
new_java_util_Collections$EmptyMap:() => Object.seal({0:2492,1:0}),
array_new_i8:(l)=>Object.seal({0:608,1:0,2:new Uint8Array(l)}),
array_len:(a)=>a[2].length,
new_java_util_ArrayList:() => Object.seal({0:1580,1:0,2:0,3:null}),
new_java_lang_Class:() => Object.seal({0:1544,1:0,2:0,3:0}),
new_java_util_Collections$EmptyList:() => Object.seal({0:2408,1:0,2:0}),
set_i32:(a,v,i) => a[i]=v,
array_new_java_lang_Object:(l)=>Object.seal({0:1888,1:0,2:Object.seal(new Array(l).fill(null))})
},
System:{
arraycopy:(src,srcPos,dest,destPos,length)=>{src=src[2];dest=dest[2];if(destPos<srcPos){for (var i=0;i<length;i++)dest[i+destPos]=src[i+srcPos];}else{for (var i=length-1;i>=0;i--)dest[i+destPos]=src[i+srcPos];}}
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;