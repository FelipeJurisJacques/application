'use strict';var wasmImports = {
native:{
setConsoleErrorString:v => console.error(v.asciiToString()),
setConsoleLogString:v => console.log(v.asciiToString())
},
NonGC:{
new_java_lang_StringBuilder:() => Object.seal({0:348,1:0,2:null,3:0}),
array_new_u16:(l)=>Object.seal({0:480,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_util_Collections$EmptySet:() => Object.seal({0:2096,1:0}),
new_java_util_Collections$UnmodifiableList:() => Object.seal({0:1768,1:0,2:null,3:null}),
new_java_lang_OutOfMemoryError:() => Object.seal({0:832,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_ThreadLocal:() => Object.seal({0:1432,1:0,2:0}),
new_java_util_concurrent_atomic_AtomicInteger:() => Object.seal({0:1904,1:0,2:0}),
get_i32:(a,i) => a[i],
array_new_i32:(l)=>Object.seal({0:656,1:0,2:new Int32Array(l)}),
new_java_lang_StringIndexOutOfBoundsException:() => Object.seal({0:568,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_NullPointerException:() => Object.seal({0:2044,1:0,2:null,3:null,4:null,5:null}),
ref_eq:(a,b) => a === b,
new_java_lang_IllegalArgumentException:() => Object.seal({0:688,1:0,2:null,3:null,4:null,5:null}),
get_anyref:(a,i) => a[i],
array_new_java_lang_StackTraceElement:(l)=>Object.seal({0:1012,1:0,2:Object.seal(new Array(l).fill(null))}),
set_anyref:(a,v,i) => a[i]=v,
array_get_i32:(a,i)=>a[2][i],
new_java_lang_String:() => Object.seal({0:252,1:0,2:null,3:0}),
get_externref:(a,i) => a[i],
new_java_util_Collections$UnmodifiableRandomAccessList:() => Object.seal({0:1716,1:0,2:null,3:null}),
array_new_java_lang_Throwable:(l)=>Object.seal({0:1400,1:0,2:Object.seal(new Array(l).fill(null))}),
array_set_i32:(a,i,v)=>a[2][i]=v,
new_java_lang_AssertionError:() => Object.seal({0:1812,1:0,2:null,3:null,4:null,5:null}),
array_new_java_io_ObjectStreamField:(l)=>Object.seal({0:1184,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_String$CaseInsensitiveComparator:() => Object.seal({0:1216,1:0}),
new_java_util_Collections$EmptyMap:() => Object.seal({0:2260,1:0}),
array_new_i8:(l)=>Object.seal({0:448,1:0,2:new Uint8Array(l)}),
array_len:(a)=>a[2].length,
new_java_util_ArrayList:() => Object.seal({0:1348,1:0,2:0,3:null}),
new_java_lang_Class:() => Object.seal({0:1312,1:0,2:0,3:0}),
new_java_util_Collections$EmptyList:() => Object.seal({0:2176,1:0,2:0}),
set_i32:(a,v,i) => a[i]=v,
array_new_java_lang_Object:(l)=>Object.seal({0:1656,1:0,2:Object.seal(new Array(l).fill(null))})
},
System:{
arraycopy:(src,srcPos,dest,destPos,length)=>{if(destPos<srcPos){for (var i=0;i<length;i++)dest[i+destPos]=src[i+srcPos];}else{for (var i=length-1;i>=0;i--)dest[i+destPos]=src[i+srcPos];}}
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;