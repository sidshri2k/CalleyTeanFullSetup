package com.dt.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {


    @Override
    public void onStart(ITestContext context) {
        System.out.println("test setup on TestLisners");
        ITestListener.super.onStart(context);
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test start on Test lisners");
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed on test listernes");
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test falied on test listernes");
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test  skiped on Test listerners");
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test finis on test listernes");
        ITestListener.super.onFinish(context);
    }
}
