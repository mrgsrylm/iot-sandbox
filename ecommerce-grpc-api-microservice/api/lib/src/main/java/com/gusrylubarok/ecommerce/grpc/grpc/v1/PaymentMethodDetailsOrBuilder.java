// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PaymentGatewayService.proto

package com.gusrylubarok.ecommerce.grpc.grpc.v1;

public interface PaymentMethodDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gusrylmubarok.v1.PaymentMethodDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.com.gusrylmubarok.v1.Card card = 1;</code>
   * @return Whether the card field is set.
   */
  boolean hasCard();
  /**
   * <code>.com.gusrylmubarok.v1.Card card = 1;</code>
   * @return The card.
   */
  com.gusrylubarok.ecommerce.grpc.grpc.v1.Card getCard();
  /**
   * <code>.com.gusrylmubarok.v1.Card card = 1;</code>
   */
  com.gusrylubarok.ecommerce.grpc.grpc.v1.CardOrBuilder getCardOrBuilder();

  /**
   * <pre>
   * The type of transaction-specific details of the payment method used in the payment,
   * one of card, stripeAccount, or you can add similar others such as paypal.
   * An additional hash is included on payment method details with a name matching this value.
   * It contains information specific to the payment method.
   * </pre>
   *
   * <code>string type = 2;</code>
   * @return The type.
   */
  java.lang.String getType();
  /**
   * <pre>
   * The type of transaction-specific details of the payment method used in the payment,
   * one of card, stripeAccount, or you can add similar others such as paypal.
   * An additional hash is included on payment method details with a name matching this value.
   * It contains information specific to the payment method.
   * </pre>
   *
   * <code>string type = 2;</code>
   * @return The bytes for type.
   */
  com.google.protobuf.ByteString
      getTypeBytes();

  /**
   * <code>.com.gusrylmubarok.v1.StripeAccount stripeAccount = 3;</code>
   * @return Whether the stripeAccount field is set.
   */
  boolean hasStripeAccount();
  /**
   * <code>.com.gusrylmubarok.v1.StripeAccount stripeAccount = 3;</code>
   * @return The stripeAccount.
   */
  com.gusrylubarok.ecommerce.grpc.grpc.v1.StripeAccount getStripeAccount();
  /**
   * <code>.com.gusrylmubarok.v1.StripeAccount stripeAccount = 3;</code>
   */
  com.gusrylubarok.ecommerce.grpc.grpc.v1.StripeAccountOrBuilder getStripeAccountOrBuilder();
}
