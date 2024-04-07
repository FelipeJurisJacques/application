'use strict';var wasmImports = {
NonGC:{
array_new_u16:(l)=>Object.seal({0:332,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_StringBuilder:() => Object.seal({0:476,1:0,2:null,3:0}),
new_java_util_Collections$EmptySet:() => Object.seal({0:2048,1:0}),
new_java_util_Collections$UnmodifiableList:() => Object.seal({0:1772,1:0,2:null,3:null}),
new_java_lang_OutOfMemoryError:() => Object.seal({0:948,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_ThreadLocal:() => Object.seal({0:1240,1:0,2:0}),
new_java_util_concurrent_atomic_AtomicInteger:() => Object.seal({0:1816,1:0,2:0}),
get_i32:(a,i) => a[i],
array_new_i32:(l)=>Object.seal({0:696,1:0,2:new Int32Array(l)}),
new_java_lang_StringIndexOutOfBoundsException:() => Object.seal({0:424,1:0,2:null,3:null,4:null,5:null}),
new_java_lang_NullPointerException:() => Object.seal({0:2000,1:0,2:null,3:null,4:null,5:null}),
ref_eq:(a,b) => a === b,
new_java_lang_IllegalArgumentException:() => Object.seal({0:728,1:0,2:null,3:null,4:null,5:null}),
get_anyref:(a,i) => a[i],
array_new_java_lang_StackTraceElement:(l)=>Object.seal({0:884,1:0,2:Object.seal(new Array(l).fill(null))}),
set_anyref:(a,v,i) => a[i]=v,
array_get_i32:(a,i)=>a[2][i],
new_java_lang_String:() => Object.seal({0:252,1:0,2:null,3:0}),
get_externref:(a,i) => a[i],
new_java_util_Collections$UnmodifiableRandomAccessList:() => Object.seal({0:1720,1:0,2:null,3:null}),
array_new_java_lang_Throwable:(l)=>Object.seal({0:1552,1:0,2:Object.seal(new Array(l).fill(null))}),
array_set_i32:(a,i,v)=>a[2][i]=v,
new_java_lang_AssertionError:() => Object.seal({0:1616,1:0,2:null,3:null,4:null,5:null}),
array_new_java_io_ObjectStreamField:(l)=>Object.seal({0:1144,1:0,2:Object.seal(new Array(l).fill(null))}),
new_java_lang_String$CaseInsensitiveComparator:() => Object.seal({0:1176,1:0}),
new_java_util_Collections$EmptyMap:() => Object.seal({0:2212,1:0}),
array_new_i8:(l)=>Object.seal({0:300,1:0,2:new Uint8Array(l)}),
array_len:(a)=>a[2].length,
new_java_util_ArrayList:() => Object.seal({0:1500,1:0,2:0,3:null}),
new_java_lang_Class:() => Object.seal({0:1304,1:0,2:0,3:0}),
new_java_util_Collections$EmptyList:() => Object.seal({0:2128,1:0,2:0}),
set_i32:(a,v,i) => a[i]=v,
array_new_java_lang_Object:(l)=>Object.seal({0:1660,1:0,2:Object.seal(new Array(l).fill(null))})
},
System:{
arraycopy:(src,srcPos,dest,destPos,length)=>{if(destPos<srcPos){for (var i=0;i<length;i++)dest[i+destPos]=src[i+srcPos];}else{for (var i=length-1;i>=0;i--)dest[i+destPos]=src[i+srcPos];}}
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;