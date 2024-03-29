// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

public final class ProductProtos {
  private ProductProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_Brand_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Brand_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_Category_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Category_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_Product_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Product_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductSearchFilter_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProductSearchFilter_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductSearchRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProductSearchRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductSearchResonse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProductSearchResonse_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_RequestedProduct_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_RequestedProduct_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductCheckoutRequest_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProductCheckoutRequest_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderDetail_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_OrderDetail_fieldAccessorTable;
  static com.google.protobuf.Descriptors.Descriptor
    internal_static_ProductCheckoutResponse_descriptor;
  static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ProductCheckoutResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rproduct.proto\"!\n\005Brand\022\n\n\002id\030\001 \002(\004\022\014\n\004" +
      "name\030\002 \002(\t\"D\n\010Category\022\n\n\002id\030\001 \002(\004\022\014\n\004na" +
      "me\030\002 \002(\t\022\036\n\026recommeded_category_id\030\003 \001(\004" +
      "\"\213\002\n\007Product\022\n\n\002id\030\001 \001(\004\022\014\n\004name\030\002 \002(\t\022\025" +
      "\n\005brand\030\003 \002(\0132\006.Brand\022\033\n\010category\030\004 \002(\0132" +
      "\t.Category\022\r\n\005color\030\005 \001(\t\022\021\n\tsell_rate\030\006" +
      " \002(\004\022\020\n\010net_rate\030\007 \002(\004\022\020\n\010quantity\030\010 \002(\r" +
      "\022\023\n\013description\030\t \001(\t\022\016\n\006imgUrl\030\n \001(\t\022\021\n" +
      "\timageUrls\030\013 \003(\t\022!\n\017recommendations\030\014 \003(" +
      "\0132\010.Product\022\021\n\tseller_id\030\r \002(\004\"m\n\023Produc",
      "tSearchFilter\022\020\n\010brand_id\030\001 \001(\004\022\023\n\013categ" +
      "ory_id\030\002 \001(\004\022\031\n\021business_group_id\030\003 \001(\004\022" +
      "\024\n\014product_name\030\004 \001(\004\"_\n\024ProductSearchRe" +
      "quest\0223\n\025product_search_filter\030\001 \001(\0132\024.P" +
      "roductSearchFilter\022\022\n\nproduct_id\030\002 \003(\004\"1" +
      "\n\024ProductSearchResonse\022\031\n\007product\030\001 \003(\0132" +
      "\010.Product\"3\n\020RequestedProduct\022\022\n\nproduct" +
      "_id\030\001 \002(\r\022\013\n\003qty\030\002 \002(\r\"j\n\026ProductCheckou" +
      "tRequest\022\020\n\010buyer_id\030\001 \002(\r\022,\n\021requested_" +
      "product\030\002 \003(\0132\021.RequestedProduct\022\020\n\010pci_",
      "info\030\003 \001(\t\"A\n\013OrderDetail\022\027\n\017order_detai" +
      "l_id\030\001 \002(\r\022\031\n\007product\030\002 \002(\0132\010.Product\"=\n" +
      "\027ProductCheckoutResponse\022\"\n\014order_detail" +
      "\030\001 \003(\0132\014.OrderDetailB\023B\rProductProtosH\001P" +
      "\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_Brand_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_Brand_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Brand_descriptor,
              new java.lang.String[] { "Id", "Name", });
          internal_static_Category_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_Category_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Category_descriptor,
              new java.lang.String[] { "Id", "Name", "RecommededCategoryId", });
          internal_static_Product_descriptor =
            getDescriptor().getMessageTypes().get(2);
          internal_static_Product_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_Product_descriptor,
              new java.lang.String[] { "Id", "Name", "Brand", "Category", "Color", "SellRate", "NetRate", "Quantity", "Description", "ImgUrl", "ImageUrls", "Recommendations", "SellerId", });
          internal_static_ProductSearchFilter_descriptor =
            getDescriptor().getMessageTypes().get(3);
          internal_static_ProductSearchFilter_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProductSearchFilter_descriptor,
              new java.lang.String[] { "BrandId", "CategoryId", "BusinessGroupId", "ProductName", });
          internal_static_ProductSearchRequest_descriptor =
            getDescriptor().getMessageTypes().get(4);
          internal_static_ProductSearchRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProductSearchRequest_descriptor,
              new java.lang.String[] { "ProductSearchFilter", "ProductId", });
          internal_static_ProductSearchResonse_descriptor =
            getDescriptor().getMessageTypes().get(5);
          internal_static_ProductSearchResonse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProductSearchResonse_descriptor,
              new java.lang.String[] { "Product", });
          internal_static_RequestedProduct_descriptor =
            getDescriptor().getMessageTypes().get(6);
          internal_static_RequestedProduct_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_RequestedProduct_descriptor,
              new java.lang.String[] { "ProductId", "Qty", });
          internal_static_ProductCheckoutRequest_descriptor =
            getDescriptor().getMessageTypes().get(7);
          internal_static_ProductCheckoutRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProductCheckoutRequest_descriptor,
              new java.lang.String[] { "BuyerId", "RequestedProduct", "PciInfo", });
          internal_static_OrderDetail_descriptor =
            getDescriptor().getMessageTypes().get(8);
          internal_static_OrderDetail_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_OrderDetail_descriptor,
              new java.lang.String[] { "OrderDetailId", "Product", });
          internal_static_ProductCheckoutResponse_descriptor =
            getDescriptor().getMessageTypes().get(9);
          internal_static_ProductCheckoutResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ProductCheckoutResponse_descriptor,
              new java.lang.String[] { "OrderDetail", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
