// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PaymentGatewayService.proto

package com.gusrylubarok.ecommerce.grpc.grpc.v1;

public interface AchCreditTransferOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gusrylmubarok.v1.AchCreditTransfer)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Account number to transfer funds to.
   * </pre>
   *
   * <code>string accountNumber = 1;</code>
   * @return The accountNumber.
   */
  java.lang.String getAccountNumber();
  /**
   * <pre>
   * Account number to transfer funds to.
   * </pre>
   *
   * <code>string accountNumber = 1;</code>
   * @return The bytes for accountNumber.
   */
  com.google.protobuf.ByteString
      getAccountNumberBytes();

  /**
   * <pre>
   * Routing transit number for the bank account to transfer funds to
   * </pre>
   *
   * <code>string routingNumber = 2;</code>
   * @return The routingNumber.
   */
  java.lang.String getRoutingNumber();
  /**
   * <pre>
   * Routing transit number for the bank account to transfer funds to
   * </pre>
   *
   * <code>string routingNumber = 2;</code>
   * @return The bytes for routingNumber.
   */
  com.google.protobuf.ByteString
      getRoutingNumberBytes();

  /**
   * <pre>
   * Uniquely identifies this particular bank account. You can use this attribute to check whether two bank accounts are the same.
   * </pre>
   *
   * <code>string fingerprint = 3;</code>
   * @return The fingerprint.
   */
  java.lang.String getFingerprint();
  /**
   * <pre>
   * Uniquely identifies this particular bank account. You can use this attribute to check whether two bank accounts are the same.
   * </pre>
   *
   * <code>string fingerprint = 3;</code>
   * @return The bytes for fingerprint.
   */
  com.google.protobuf.ByteString
      getFingerprintBytes();

  /**
   * <pre>
   * Name of the bank associated with the routing number.
   * </pre>
   *
   * <code>string bankName = 4;</code>
   * @return The bankName.
   */
  java.lang.String getBankName();
  /**
   * <pre>
   * Name of the bank associated with the routing number.
   * </pre>
   *
   * <code>string bankName = 4;</code>
   * @return The bytes for bankName.
   */
  com.google.protobuf.ByteString
      getBankNameBytes();

  /**
   * <pre>
   * SWIFT code of the bank associated with the routing number.
   * </pre>
   *
   * <code>string swiftCode = 5;</code>
   * @return The swiftCode.
   */
  java.lang.String getSwiftCode();
  /**
   * <pre>
   * SWIFT code of the bank associated with the routing number.
   * </pre>
   *
   * <code>string swiftCode = 5;</code>
   * @return The bytes for swiftCode.
   */
  com.google.protobuf.ByteString
      getSwiftCodeBytes();
}
