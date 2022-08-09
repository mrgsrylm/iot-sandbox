// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PaymentGatewayService.proto

package com.gusrylubarok.ecommerce.grpc.grpc.v1;

public interface UpdateChargeReqOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gusrylmubarok.v1.UpdateChargeReq)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Id of the Charge for which update request is being called.
   * </pre>
   *
   * <code>string chargeId = 1;</code>
   * @return The chargeId.
   */
  java.lang.String getChargeId();
  /**
   * <pre>
   * Id of the Charge for which update request is being called.
   * </pre>
   *
   * <code>string chargeId = 1;</code>
   * @return The bytes for chargeId.
   */
  com.google.protobuf.ByteString
      getChargeIdBytes();

  /**
   * <pre>
   * Optional. The ID of an existing customer that will be associated with this request.
   * This field may only be updated if there is no existing associated customer with this charge.
   * </pre>
   *
   * <code>string customerId = 2;</code>
   * @return The customerId.
   */
  java.lang.String getCustomerId();
  /**
   * <pre>
   * Optional. The ID of an existing customer that will be associated with this request.
   * This field may only be updated if there is no existing associated customer with this charge.
   * </pre>
   *
   * <code>string customerId = 2;</code>
   * @return The bytes for customerId.
   */
  com.google.protobuf.ByteString
      getCustomerIdBytes();

  /**
   * <pre>
   * Optional. An arbitrary string which you can attach to a Charge object. It is displayed when
   * in the web interface alongside the charge. Note that if you use Stripe to send automatic email
   * receipts to your customers, your receipt emails will include the description of the charge(s)
   * that they are describing.
   * </pre>
   *
   * <code>string description = 3;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * Optional. An arbitrary string which you can attach to a Charge object. It is displayed when
   * in the web interface alongside the charge. Note that if you use Stripe to send automatic email
   * receipts to your customers, your receipt emails will include the description of the charge(s)
   * that they are describing.
   * </pre>
   *
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * Optional. The email address to which this charge’s receipt will be sent. The receipt will not
   * be sent until the charge is paid, and no receipts will be sent for test mode charges. If this
   * charge is for a Customer, the email address specified here will override the customer’s email
   * address. If receiptEmail is specified for a charge in live mode, a receipt will be sent
   * regardless of your email settings.
   * </pre>
   *
   * <code>string receiptEmail = 4;</code>
   * @return The receiptEmail.
   */
  java.lang.String getReceiptEmail();
  /**
   * <pre>
   * Optional. The email address to which this charge’s receipt will be sent. The receipt will not
   * be sent until the charge is paid, and no receipts will be sent for test mode charges. If this
   * charge is for a Customer, the email address specified here will override the customer’s email
   * address. If receiptEmail is specified for a charge in live mode, a receipt will be sent
   * regardless of your email settings.
   * </pre>
   *
   * <code>string receiptEmail = 4;</code>
   * @return The bytes for receiptEmail.
   */
  com.google.protobuf.ByteString
      getReceiptEmailBytes();
}
