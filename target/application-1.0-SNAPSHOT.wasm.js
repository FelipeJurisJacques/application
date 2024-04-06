'use strict';var wasmImports = {
NonGC:{
array_get_i32:(a,i)=>a[2][i],
array_len:(a)=>a[2].length
}
};
if (typeof module !== 'undefined') module.exports = wasmImports;