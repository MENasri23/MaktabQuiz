// MyAIDL.aidl
package com.example.maktabquiz.screen.enqueue;

// Declare any non-default types here with import statements

interface MyAIDL {

       /** Request the process ID of this service */
       int getPid();

       /** Count of received connection requests from clients */
       int getConnectionCount();

       /** Set displayed value of screen */
       void setDisplayedValue(String packageName, int pid, String data);



}