
cmake_minimum_required(VERSION 3.4.1)

#增量更新 需要用到的c代码
#bzip2源码下载地址   -->   http://www.bzip.org/
#(Binary diff/patch utility)bsPatch下载地址 --- > http://www.daemonology.net/bsdiff/
#(Binary diff/patch utility)bsPatch下载包里面还有个bsdiff此C文件是进行差分算法
#说明:上面两个包里面的C文件,凡是有main 函数,需要自己更改函数名字
add_library(
              BsPatch
              SHARED
              src/main/cpp/incremental/bzip2/blocksort.c
              src/main/cpp/incremental/bzip2/bzip2.c
              src/main/cpp/incremental/bzip2/bzip2recover.c
              src/main/cpp/incremental/bzip2/bzlib.c
              src/main/cpp/incremental/bzip2/compress.c
              src/main/cpp/incremental/bzip2/crctable.c
              src/main/cpp/incremental/bzip2/decompress.c
              src/main/cpp/incremental/bzip2/dlltest.c
              src/main/cpp/incremental/bzip2/huffman.c
              src/main/cpp/incremental/bzip2/mk251.c
              src/main/cpp/incremental/bzip2/randtable.c
              src/main/cpp/incremental/bzip2/spewG.c
              src/main/cpp/incremental/bzip2/unzcrash.c
              src/main/cpp/incremental/bspatch.c
               )
find_library(
              log-lib
              log )
#添加支持C++,不然会出现各种C++兼容问题
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")
#include_dircetories : 包含头文件到类库里面 参数-->有头文件(.h文件)所涉及到的目录
include_directories(src/main/cpp)
include_directories(src/main/cpp/incremental)
include_directories(src/main/cpp/incremental/bzip2)
target_link_libraries(
                       BsPatch
                       ${log-lib} )
