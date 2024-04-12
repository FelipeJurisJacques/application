Object.prototype.asciiToString = function () {
    const list = []
    for (let ascii of this[2]) {
        list.push(String.fromCharCode(ascii))
    }
    return list.join('')
}
// String.prototype.toAscii = function () {
//     return [1, 0, 1, 0]
// }
// wasmImports.NonGC.array_set_i32 = (a, i, v) => {
//     a[2][i] = v
// }
// wasmImports.System.arraycopy = (src, srcPos, dest, destPos, length) => {
//     if (destPos < srcPos) {
//         for (var i = 0; i < length; i++) {
//             dest[i + destPos] = src[i + srcPos]
//         }
//     } else {
//         if (!Object.isExtensible(dest)) {
//             dest = Object.assign({}, dest)
//         }
//         for (var i = length - 1; i >= 0; i--) {
//             dest[i + destPos] = src[i + srcPos]
//         }
//     }
//     return dest
// }
WebAssembly.instantiateStreaming(fetch(new URL(
    '/target/application-1.0-SNAPSHOT.wasm',
    window.location.origin
)), wasmImports).then(result => {
    result.instance.exports.main()
}).catch(error => {
    console.error(error)
})