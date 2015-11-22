// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

/**
 * Protobuf type {@code ProductSearchRequest}
 */
public  final class ProductSearchRequest extends
    com.google.protobuf.GeneratedMessage
    implements ProductSearchRequestOrBuilder {
  // Use ProductSearchRequest.newBuilder() to construct.
  private ProductSearchRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private ProductSearchRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final ProductSearchRequest defaultInstance;
  public static ProductSearchRequest getDefaultInstance() {
    return defaultInstance;
  }

  public ProductSearchRequest getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private ProductSearchRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            ProductSearchFilter.Builder subBuilder = null;
            if (((bitField0_ & 0x00000001) == 0x00000001)) {
              subBuilder = productSearchFilter_.toBuilder();
            }
            productSearchFilter_ = input.readMessage(ProductSearchFilter.PARSER, extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(productSearchFilter_);
              productSearchFilter_ = subBuilder.buildPartial();
            }
            bitField0_ |= 0x00000001;
            break;
          }
          case 16: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              productId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            productId_.add(input.readUInt64());
            break;
          }
          case 18: {
            int length = input.readRawVarint32();
            int limit = input.pushLimit(length);
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
              productId_ = new java.util.ArrayList<java.lang.Long>();
              mutable_bitField0_ |= 0x00000002;
            }
            while (input.getBytesUntilLimit() > 0) {
              productId_.add(input.readUInt64());
            }
            input.popLimit(limit);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
        productId_ = java.util.Collections.unmodifiableList(productId_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ProductProtos.internal_static_ProductSearchRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ProductProtos.internal_static_ProductSearchRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ProductSearchRequest.class, ProductSearchRequest.Builder.class);
  }

  public static com.google.protobuf.Parser<ProductSearchRequest> PARSER =
      new com.google.protobuf.AbstractParser<ProductSearchRequest>() {
    public ProductSearchRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductSearchRequest(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<ProductSearchRequest> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  // optional .ProductSearchFilter product_search_filter = 1;
  public static final int PRODUCT_SEARCH_FILTER_FIELD_NUMBER = 1;
  private ProductSearchFilter productSearchFilter_;
  /**
   * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
   */
  public boolean hasProductSearchFilter() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
   */
  public ProductSearchFilter getProductSearchFilter() {
    return productSearchFilter_;
  }
  /**
   * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
   */
  public ProductSearchFilterOrBuilder getProductSearchFilterOrBuilder() {
    return productSearchFilter_;
  }

  // repeated uint64 product_id = 2;
  public static final int PRODUCT_ID_FIELD_NUMBER = 2;
  private java.util.List<java.lang.Long> productId_;
  /**
   * <code>repeated uint64 product_id = 2;</code>
   */
  public java.util.List<java.lang.Long>
      getProductIdList() {
    return productId_;
  }
  /**
   * <code>repeated uint64 product_id = 2;</code>
   */
  public int getProductIdCount() {
    return productId_.size();
  }
  /**
   * <code>repeated uint64 product_id = 2;</code>
   */
  public long getProductId(int index) {
    return productId_.get(index);
  }

  private void initFields() {
    productSearchFilter_ = ProductSearchFilter.getDefaultInstance();
    productId_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeMessage(1, productSearchFilter_);
    }
    for (int i = 0; i < productId_.size(); i++) {
      output.writeUInt64(2, productId_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, productSearchFilter_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < productId_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeUInt64SizeNoTag(productId_.get(i));
      }
      size += dataSize;
      size += 1 * getProductIdList().size();
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static ProductSearchRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ProductSearchRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ProductSearchRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ProductSearchRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ProductSearchRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ProductSearchRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static ProductSearchRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static ProductSearchRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static ProductSearchRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ProductSearchRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(ProductSearchRequest prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ProductSearchRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements ProductSearchRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ProductProtos.internal_static_ProductSearchRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ProductProtos.internal_static_ProductSearchRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProductSearchRequest.class, ProductSearchRequest.Builder.class);
    }

    // Construct using ProductSearchRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getProductSearchFilterFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      if (productSearchFilterBuilder_ == null) {
        productSearchFilter_ = ProductSearchFilter.getDefaultInstance();
      } else {
        productSearchFilterBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      productId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ProductProtos.internal_static_ProductSearchRequest_descriptor;
    }

    public ProductSearchRequest getDefaultInstanceForType() {
      return ProductSearchRequest.getDefaultInstance();
    }

    public ProductSearchRequest build() {
      ProductSearchRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ProductSearchRequest buildPartial() {
      ProductSearchRequest result = new ProductSearchRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      if (productSearchFilterBuilder_ == null) {
        result.productSearchFilter_ = productSearchFilter_;
      } else {
        result.productSearchFilter_ = productSearchFilterBuilder_.build();
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        productId_ = java.util.Collections.unmodifiableList(productId_);
        bitField0_ = (bitField0_ & ~0x00000002);
      }
      result.productId_ = productId_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ProductSearchRequest) {
        return mergeFrom((ProductSearchRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ProductSearchRequest other) {
      if (other == ProductSearchRequest.getDefaultInstance()) return this;
      if (other.hasProductSearchFilter()) {
        mergeProductSearchFilter(other.getProductSearchFilter());
      }
      if (!other.productId_.isEmpty()) {
        if (productId_.isEmpty()) {
          productId_ = other.productId_;
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          ensureProductIdIsMutable();
          productId_.addAll(other.productId_);
        }
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ProductSearchRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ProductSearchRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // optional .ProductSearchFilter product_search_filter = 1;
    private ProductSearchFilter productSearchFilter_ = ProductSearchFilter.getDefaultInstance();
    private com.google.protobuf.SingleFieldBuilder<
        ProductSearchFilter, ProductSearchFilter.Builder, ProductSearchFilterOrBuilder> productSearchFilterBuilder_;
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public boolean hasProductSearchFilter() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public ProductSearchFilter getProductSearchFilter() {
      if (productSearchFilterBuilder_ == null) {
        return productSearchFilter_;
      } else {
        return productSearchFilterBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public Builder setProductSearchFilter(ProductSearchFilter value) {
      if (productSearchFilterBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        productSearchFilter_ = value;
        onChanged();
      } else {
        productSearchFilterBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public Builder setProductSearchFilter(
        ProductSearchFilter.Builder builderForValue) {
      if (productSearchFilterBuilder_ == null) {
        productSearchFilter_ = builderForValue.build();
        onChanged();
      } else {
        productSearchFilterBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public Builder mergeProductSearchFilter(ProductSearchFilter value) {
      if (productSearchFilterBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001) &&
            productSearchFilter_ != ProductSearchFilter.getDefaultInstance()) {
          productSearchFilter_ =
            ProductSearchFilter.newBuilder(productSearchFilter_).mergeFrom(value).buildPartial();
        } else {
          productSearchFilter_ = value;
        }
        onChanged();
      } else {
        productSearchFilterBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      return this;
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public Builder clearProductSearchFilter() {
      if (productSearchFilterBuilder_ == null) {
        productSearchFilter_ = ProductSearchFilter.getDefaultInstance();
        onChanged();
      } else {
        productSearchFilterBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public ProductSearchFilter.Builder getProductSearchFilterBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getProductSearchFilterFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    public ProductSearchFilterOrBuilder getProductSearchFilterOrBuilder() {
      if (productSearchFilterBuilder_ != null) {
        return productSearchFilterBuilder_.getMessageOrBuilder();
      } else {
        return productSearchFilter_;
      }
    }
    /**
     * <code>optional .ProductSearchFilter product_search_filter = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        ProductSearchFilter, ProductSearchFilter.Builder, ProductSearchFilterOrBuilder> 
        getProductSearchFilterFieldBuilder() {
      if (productSearchFilterBuilder_ == null) {
        productSearchFilterBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            ProductSearchFilter, ProductSearchFilter.Builder, ProductSearchFilterOrBuilder>(
                productSearchFilter_,
                getParentForChildren(),
                isClean());
        productSearchFilter_ = null;
      }
      return productSearchFilterBuilder_;
    }

    // repeated uint64 product_id = 2;
    private java.util.List<java.lang.Long> productId_ = java.util.Collections.emptyList();
    private void ensureProductIdIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        productId_ = new java.util.ArrayList<java.lang.Long>(productId_);
        bitField0_ |= 0x00000002;
       }
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public java.util.List<java.lang.Long>
        getProductIdList() {
      return java.util.Collections.unmodifiableList(productId_);
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public int getProductIdCount() {
      return productId_.size();
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public long getProductId(int index) {
      return productId_.get(index);
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public Builder setProductId(
        int index, long value) {
      ensureProductIdIsMutable();
      productId_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public Builder addProductId(long value) {
      ensureProductIdIsMutable();
      productId_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public Builder addAllProductId(
        java.lang.Iterable<? extends java.lang.Long> values) {
      ensureProductIdIsMutable();
      super.addAll(values, productId_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated uint64 product_id = 2;</code>
     */
    public Builder clearProductId() {
      productId_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ProductSearchRequest)
  }

  static {
    defaultInstance = new ProductSearchRequest(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:ProductSearchRequest)
}

