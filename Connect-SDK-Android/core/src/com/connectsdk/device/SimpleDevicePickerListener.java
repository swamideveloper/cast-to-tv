package com.connectsdk.device;

public interface SimpleDevicePickerListener extends DevicePickerListener {

    public void onPrepareDevice(ConnectableDevice device);

    public void onPickDevice(ConnectableDevice device);

    public void onPickDeviceFailed(boolean canceled);
}
