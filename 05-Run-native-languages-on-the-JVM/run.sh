#!/usr/bin/env bash
source ../utils/bash-env.sh

echo "Compile using standard clang (the LLVM C compiler) \U1F916"
clang --version

clang -c -emit-llvm oggenc.c

echo "Compilation result \U1F91E"
du -h *.bc

echo "Run this directly using GraalVM using the lli command (LLVM bitcode interpreter)"
$GRAALVM_CE_HOME/bin/lli --experimental-options --llvm.verifyBitcode=false oggenc.bc 62284main_onesmall2.wav

echo "Result ogg file"
du -h *.wav *.ogg

echo "Play the result \U1F3B5"
# apt install vorbis-tools
ogg123 --skip 13 62284main_onesmall2.ogg
