package com.connectsdk.device;

public interface DevicePickerListener {
    public void onPickDevice(ConnectableDevice device);

    public void onPickDeviceFailed(boolean canceled);
}
