//package com.xiangyang.concurrent;
//
//
//import sun.nio.ch.ThreadPool;
//
//import java.io.*;
//import java.net.Socket;
//
///**
// * @Author yixiangyang
// * @Date 2022/4/20 20:55
// */
//public class SimpleHttpServer {
//    //处理httpRequest的线程池
////    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>();
////    static new defaultThreadPool
//
//    static class HttpRequestHandler implements Runnable{
//        private Socket socket;
//
//        public HttpRequestHandler(Socket socket){
//            this.socket = socket;
//        }
//
//        @Override
//        public void run() {
//            String line = null;
//            BufferedReader br = null;
//            BufferedReader reader = null;
//            PrintWriter out = null;
//            InputStream in = null;
//            try {
//                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                String header = reader.readLine();
//                //由相对路径计算出绝对路径
//            }catch (Exception ex){
//                out.println("HTTP/1.1 500");
//                out.println("");
//                out.flush();
//            }finally {
//                close(br,in,reader,out,socket);
//            }
//
//
//        }
//
//        private static void close(Closeable... closeables){
//            if(closeables !=null){
//                for(Closeable closeable:closeables){
//                    try {
//                        closeable.close();
//                    }catch (Exception ex){
//
//                    }
//                }
//            }
//        }
//    }
//}
