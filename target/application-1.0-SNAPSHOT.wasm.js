'use strict';var wasmImports = {
console:{
errorString:(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.error(l.join('')); },
logString:(v) => { const l = []; for (let i of v[2]) { l.push(String.fromCharCode(i)); } console.log(l.join('')); }
},
native:{
setHtmlElementInnerText:(o, v) => { o.innerText = v.asciiToString() },
getDocument:() => { return document },
getHtmlBodyElement:o => { return o.body },
setHtmlElementAppend:(o, c) => { o.append(c) },
getDocumentCreateElementByChar:(o, n) => { return o.createElement(String.fromCharCode(n)) }
},
NonGC:{
array_new_u16:(l)=>Object.seal({0:592,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_StringBuilder:() => Object.seal({0:824,1:0,2:null,3:0}),
new_java_util_Collections$EmptySet:() => Object.seal({0:2320,1:0}),
new_java_util_Collections$UnmodifiableList:() => Object.seal({0:1992,1:0,2:null,3:null}),
new_java_lang_OutOfMemoryError:() => Object.seal({0:1200,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_ThreadLocal:() => Object.seal({0:1624,1:0,2:0}),
new_java_util_concurrent_atomic_AtomicInteger:() => Object.seal({0:2128,1:0,2:0}),
get_i32:(a,i) => a[i],
array_new_i32:(l)=>Object.seal({0:560,1:0,2:new Int32Array(l)}),
new_java_lang_StringIndexOutOfBoundsException:() => Object.seal({0:736,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_NullPointerException:() => Object.seal({0:2268,1:0,2:null,3:null,4:null,5:null}),
new_org_application_web_elements_Body:() => Object.seal({0:308,1:0,2:null}),
ref_eq:(a,b) => a === b,
new_java_lang_IllegalArgumentException:() => Object.seal({0:1052,1:0,2:null,3:null,4:null,5:null}),
get_anyref:(a,i) => a[i],
new_org_application_web_elements_Paragraph:() => Object.seal({0:252,1:0,2:null}),
array_new_java_lang_StackTraceElement:(l)=>Object.seal({0:1136,1:0,2:Object.seal(new Array(l).fill(null))}),
set_anyref:(a,v,i) => a[i]=v,
array_get_i32:(a,i)=>a[2][i],
new_java_lang_String:() => Object.seal({0:404,1:0,2:null,3:0}),
get_externref:(a,i) => a[i],
new_java_util_Collections$UnmodifiableRandomAccessList:() => Object.seal({0:1940,1:0,2:null,3:null}),
array_new_java_lang_Throwable:(l)=>Object.seal({0:1592,1:0,2:Object.seal(new Array(l).fill(null))}),
array_set_i32:(a,i,v)=>a[2][i]=v,
new_java_lang_AssertionError:() => Object.seal({0:2036,1:0,2:null,3:null,4:null,5:null}),
array_new_java_io_ObjectStreamField:(l)=>Object.seal({0:1408,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_String$CaseInsensitiveComparator:() => Object.seal({0:1440,1:0}),
new_java_util_Collections$EmptyMap:() => Object.seal({0:2484,1:0}),
array_new_i8:(l)=>Object.seal({0:528,1:0,2:new Uint8Array(l)}),
array_len:(a)=>a[2].length,
new_java_util_ArrayList:() => Object.seal({0:1540,1:0,2:0,3:null}),
new_java_lang_Class:() => Object.seal({0:1504,1:0,2:0,3:0}),
new_java_util_Collections$EmptyList:() => Object.seal({0:2400,1:0,2:0}),
set_i32:(a,v,i) => a[i]=v,
array_new_java_lang_Object:(l)=>Object.seal({0:1880,1:0,2:Object.seal(new Array(l).fill(null))})
},
System:{
arraycopy:(src,srcPos,dest,destPos,length)=>{if(destPos<srcPos){for (var i=0;i<length;i++)dest[i+destPos]=src[i+srcPos];}else{for (var i=length-1;i>=0;i--)dest[i+destPos]=src[i+srcPos];}}
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;