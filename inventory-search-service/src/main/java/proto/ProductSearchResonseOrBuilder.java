package proto;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

public interface ProductSearchResonseOrBuilder
    extends com.google.protobuf.MessageOrBuilder {

  // repeated .Product product = 1;
  /**
   * <code>repeated .Product product = 1;</code>
   */
  java.util.List<Product> 
      getProductList();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  Product getProduct(int index);
  /**
   * <code>repeated .Product product = 1;</code>
   */
  int getProductCount();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  java.util.List<? extends ProductOrBuilder> 
      getProductOrBuilderList();
  /**
   * <code>repeated .Product product = 1;</code>
   */
  ProductOrBuilder getProductOrBuilder(
      int index);
}