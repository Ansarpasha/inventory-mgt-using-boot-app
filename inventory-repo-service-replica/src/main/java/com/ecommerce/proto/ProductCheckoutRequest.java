// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

/**
 * Protobuf type {@code ProductCheckoutRequest}
 */
public  final class ProductCheckoutRequest extends
    com.google.protobuf.GeneratedMessage
    implements ProductCheckoutRequestOrBuilder {
  // Use ProductCheckoutRequest.newBuilder() to construct.
  private ProductCheckoutRequest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private ProductCheckoutRequest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final ProductCheckoutRequest defaultInstance;
  public static ProductCheckoutRequest getDefaultInstance() {
    return defaultInstance;
  }

  public ProductCheckoutRequest getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private ProductCheckoutRequest(
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
          case 8: {
            bitField0_ |= 0x00000001;
            buyerId_ = input.readUInt32();
            break;
          }
          case 18: {
            if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
              requestedProduct_ = new java.util.ArrayList<RequestedProduct>();
              mutable_bitField0_ |= 0x00000002;
            }
            requestedProduct_.add(input.readMessage(RequestedProduct.PARSER, extensionRegistry));
            break;
          }
          case 26: {
            bitField0_ |= 0x00000002;
            pciInfo_ = input.readBytes();
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
        requestedProduct_ = java.util.Collections.unmodifiableList(requestedProduct_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ProductProtos.internal_static_ProductCheckoutRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ProductProtos.internal_static_ProductCheckoutRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ProductCheckoutRequest.class, ProductCheckoutRequest.Builder.class);
  }

  public static com.google.protobuf.Parser<ProductCheckoutRequest> PARSER =
      new com.google.protobuf.AbstractParser<ProductCheckoutRequest>() {
    public ProductCheckoutRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ProductCheckoutRequest(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<ProductCheckoutRequest> getParserForType() {
    return PARSER;
  }

  private int bitField0_;
  // required uint32 buyer_id = 1;
  public static final int BUYER_ID_FIELD_NUMBER = 1;
  private int buyerId_;
  /**
   * <code>required uint32 buyer_id = 1;</code>
   */
  public boolean hasBuyerId() {
    return ((bitField0_ & 0x00000001) == 0x00000001);
  }
  /**
   * <code>required uint32 buyer_id = 1;</code>
   */
  public int getBuyerId() {
    return buyerId_;
  }

  // repeated .RequestedProduct requested_product = 2;
  public static final int REQUESTED_PRODUCT_FIELD_NUMBER = 2;
  private java.util.List<RequestedProduct> requestedProduct_;
  /**
   * <code>repeated .RequestedProduct requested_product = 2;</code>
   */
  public java.util.List<RequestedProduct> getRequestedProductList() {
    return requestedProduct_;
  }
  /**
   * <code>repeated .RequestedProduct requested_product = 2;</code>
   */
  public java.util.List<? extends RequestedProductOrBuilder> 
      getRequestedProductOrBuilderList() {
    return requestedProduct_;
  }
  /**
   * <code>repeated .RequestedProduct requested_product = 2;</code>
   */
  public int getRequestedProductCount() {
    return requestedProduct_.size();
  }
  /**
   * <code>repeated .RequestedProduct requested_product = 2;</code>
   */
  public RequestedProduct getRequestedProduct(int index) {
    return requestedProduct_.get(index);
  }
  /**
   * <code>repeated .RequestedProduct requested_product = 2;</code>
   */
  public RequestedProductOrBuilder getRequestedProductOrBuilder(
      int index) {
    return requestedProduct_.get(index);
  }

  // optional string pci_info = 3;
  public static final int PCI_INFO_FIELD_NUMBER = 3;
  private java.lang.Object pciInfo_;
  /**
   * <code>optional string pci_info = 3;</code>
   */
  public boolean hasPciInfo() {
    return ((bitField0_ & 0x00000002) == 0x00000002);
  }
  /**
   * <code>optional string pci_info = 3;</code>
   */
  public java.lang.String getPciInfo() {
    java.lang.Object ref = pciInfo_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      if (bs.isValidUtf8()) {
        pciInfo_ = s;
      }
      return s;
    }
  }
  /**
   * <code>optional string pci_info = 3;</code>
   */
  public com.google.protobuf.ByteString
      getPciInfoBytes() {
    java.lang.Object ref = pciInfo_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      pciInfo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private void initFields() {
    buyerId_ = 0;
    requestedProduct_ = java.util.Collections.emptyList();
    pciInfo_ = "";
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    if (!hasBuyerId()) {
      memoizedIsInitialized = 0;
      return false;
    }
    for (int i = 0; i < getRequestedProductCount(); i++) {
      if (!getRequestedProduct(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    if (((bitField0_ & 0x00000001) == 0x00000001)) {
      output.writeUInt32(1, buyerId_);
    }
    for (int i = 0; i < requestedProduct_.size(); i++) {
      output.writeMessage(2, requestedProduct_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      output.writeBytes(3, getPciInfoBytes());
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
        .computeUInt32Size(1, buyerId_);
    }
    for (int i = 0; i < requestedProduct_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, requestedProduct_.get(i));
    }
    if (((bitField0_ & 0x00000002) == 0x00000002)) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(3, getPciInfoBytes());
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

  public static ProductCheckoutRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ProductCheckoutRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ProductCheckoutRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ProductCheckoutRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ProductCheckoutRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ProductCheckoutRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static ProductCheckoutRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static ProductCheckoutRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static ProductCheckoutRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static ProductCheckoutRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(ProductCheckoutRequest prototype) {
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
   * Protobuf type {@code ProductCheckoutRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements ProductCheckoutRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ProductProtos.internal_static_ProductCheckoutRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ProductProtos.internal_static_ProductCheckoutRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProductCheckoutRequest.class, ProductCheckoutRequest.Builder.class);
    }

    // Construct using ProductCheckoutRequest.newBuilder()
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
        getRequestedProductFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      buyerId_ = 0;
      bitField0_ = (bitField0_ & ~0x00000001);
      if (requestedProductBuilder_ == null) {
        requestedProduct_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
      } else {
        requestedProductBuilder_.clear();
      }
      pciInfo_ = "";
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ProductProtos.internal_static_ProductCheckoutRequest_descriptor;
    }

    public ProductCheckoutRequest getDefaultInstanceForType() {
      return ProductCheckoutRequest.getDefaultInstance();
    }

    public ProductCheckoutRequest build() {
      ProductCheckoutRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public ProductCheckoutRequest buildPartial() {
      ProductCheckoutRequest result = new ProductCheckoutRequest(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
        to_bitField0_ |= 0x00000001;
      }
      result.buyerId_ = buyerId_;
      if (requestedProductBuilder_ == null) {
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          requestedProduct_ = java.util.Collections.unmodifiableList(requestedProduct_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.requestedProduct_ = requestedProduct_;
      } else {
        result.requestedProduct_ = requestedProductBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
        to_bitField0_ |= 0x00000002;
      }
      result.pciInfo_ = pciInfo_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ProductCheckoutRequest) {
        return mergeFrom((ProductCheckoutRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ProductCheckoutRequest other) {
      if (other == ProductCheckoutRequest.getDefaultInstance()) return this;
      if (other.hasBuyerId()) {
        setBuyerId(other.getBuyerId());
      }
      if (requestedProductBuilder_ == null) {
        if (!other.requestedProduct_.isEmpty()) {
          if (requestedProduct_.isEmpty()) {
            requestedProduct_ = other.requestedProduct_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureRequestedProductIsMutable();
            requestedProduct_.addAll(other.requestedProduct_);
          }
          onChanged();
        }
      } else {
        if (!other.requestedProduct_.isEmpty()) {
          if (requestedProductBuilder_.isEmpty()) {
            requestedProductBuilder_.dispose();
            requestedProductBuilder_ = null;
            requestedProduct_ = other.requestedProduct_;
            bitField0_ = (bitField0_ & ~0x00000002);
            requestedProductBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getRequestedProductFieldBuilder() : null;
          } else {
            requestedProductBuilder_.addAllMessages(other.requestedProduct_);
          }
        }
      }
      if (other.hasPciInfo()) {
        bitField0_ |= 0x00000004;
        pciInfo_ = other.pciInfo_;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      if (!hasBuyerId()) {
        
        return false;
      }
      for (int i = 0; i < getRequestedProductCount(); i++) {
        if (!getRequestedProduct(i).isInitialized()) {
          
          return false;
        }
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ProductCheckoutRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ProductCheckoutRequest) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // required uint32 buyer_id = 1;
    private int buyerId_ ;
    /**
     * <code>required uint32 buyer_id = 1;</code>
     */
    public boolean hasBuyerId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 buyer_id = 1;</code>
     */
    public int getBuyerId() {
      return buyerId_;
    }
    /**
     * <code>required uint32 buyer_id = 1;</code>
     */
    public Builder setBuyerId(int value) {
      bitField0_ |= 0x00000001;
      buyerId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>required uint32 buyer_id = 1;</code>
     */
    public Builder clearBuyerId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      buyerId_ = 0;
      onChanged();
      return this;
    }

    // repeated .RequestedProduct requested_product = 2;
    private java.util.List<RequestedProduct> requestedProduct_ =
      java.util.Collections.emptyList();
    private void ensureRequestedProductIsMutable() {
      if (!((bitField0_ & 0x00000002) == 0x00000002)) {
        requestedProduct_ = new java.util.ArrayList<RequestedProduct>(requestedProduct_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        RequestedProduct, RequestedProduct.Builder, RequestedProductOrBuilder> requestedProductBuilder_;

    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public java.util.List<RequestedProduct> getRequestedProductList() {
      if (requestedProductBuilder_ == null) {
        return java.util.Collections.unmodifiableList(requestedProduct_);
      } else {
        return requestedProductBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public int getRequestedProductCount() {
      if (requestedProductBuilder_ == null) {
        return requestedProduct_.size();
      } else {
        return requestedProductBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public RequestedProduct getRequestedProduct(int index) {
      if (requestedProductBuilder_ == null) {
        return requestedProduct_.get(index);
      } else {
        return requestedProductBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder setRequestedProduct(
        int index, RequestedProduct value) {
      if (requestedProductBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestedProductIsMutable();
        requestedProduct_.set(index, value);
        onChanged();
      } else {
        requestedProductBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder setRequestedProduct(
        int index, RequestedProduct.Builder builderForValue) {
      if (requestedProductBuilder_ == null) {
        ensureRequestedProductIsMutable();
        requestedProduct_.set(index, builderForValue.build());
        onChanged();
      } else {
        requestedProductBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder addRequestedProduct(RequestedProduct value) {
      if (requestedProductBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestedProductIsMutable();
        requestedProduct_.add(value);
        onChanged();
      } else {
        requestedProductBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder addRequestedProduct(
        int index, RequestedProduct value) {
      if (requestedProductBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureRequestedProductIsMutable();
        requestedProduct_.add(index, value);
        onChanged();
      } else {
        requestedProductBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder addRequestedProduct(
        RequestedProduct.Builder builderForValue) {
      if (requestedProductBuilder_ == null) {
        ensureRequestedProductIsMutable();
        requestedProduct_.add(builderForValue.build());
        onChanged();
      } else {
        requestedProductBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder addRequestedProduct(
        int index, RequestedProduct.Builder builderForValue) {
      if (requestedProductBuilder_ == null) {
        ensureRequestedProductIsMutable();
        requestedProduct_.add(index, builderForValue.build());
        onChanged();
      } else {
        requestedProductBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder addAllRequestedProduct(
        java.lang.Iterable<? extends RequestedProduct> values) {
      if (requestedProductBuilder_ == null) {
        ensureRequestedProductIsMutable();
        super.addAll(values, requestedProduct_);
        onChanged();
      } else {
        requestedProductBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder clearRequestedProduct() {
      if (requestedProductBuilder_ == null) {
        requestedProduct_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        requestedProductBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public Builder removeRequestedProduct(int index) {
      if (requestedProductBuilder_ == null) {
        ensureRequestedProductIsMutable();
        requestedProduct_.remove(index);
        onChanged();
      } else {
        requestedProductBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public RequestedProduct.Builder getRequestedProductBuilder(
        int index) {
      return getRequestedProductFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public RequestedProductOrBuilder getRequestedProductOrBuilder(
        int index) {
      if (requestedProductBuilder_ == null) {
        return requestedProduct_.get(index);  } else {
        return requestedProductBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public java.util.List<? extends RequestedProductOrBuilder> 
         getRequestedProductOrBuilderList() {
      if (requestedProductBuilder_ != null) {
        return requestedProductBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(requestedProduct_);
      }
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public RequestedProduct.Builder addRequestedProductBuilder() {
      return getRequestedProductFieldBuilder().addBuilder(
          RequestedProduct.getDefaultInstance());
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public RequestedProduct.Builder addRequestedProductBuilder(
        int index) {
      return getRequestedProductFieldBuilder().addBuilder(
          index, RequestedProduct.getDefaultInstance());
    }
    /**
     * <code>repeated .RequestedProduct requested_product = 2;</code>
     */
    public java.util.List<RequestedProduct.Builder> 
         getRequestedProductBuilderList() {
      return getRequestedProductFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        RequestedProduct, RequestedProduct.Builder, RequestedProductOrBuilder> 
        getRequestedProductFieldBuilder() {
      if (requestedProductBuilder_ == null) {
        requestedProductBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            RequestedProduct, RequestedProduct.Builder, RequestedProductOrBuilder>(
                requestedProduct_,
                ((bitField0_ & 0x00000002) == 0x00000002),
                getParentForChildren(),
                isClean());
        requestedProduct_ = null;
      }
      return requestedProductBuilder_;
    }

    // optional string pci_info = 3;
    private java.lang.Object pciInfo_ = "";
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public boolean hasPciInfo() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public java.lang.String getPciInfo() {
      java.lang.Object ref = pciInfo_;
      if (!(ref instanceof java.lang.String)) {
        java.lang.String s = ((com.google.protobuf.ByteString) ref)
            .toStringUtf8();
        pciInfo_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPciInfoBytes() {
      java.lang.Object ref = pciInfo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pciInfo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public Builder setPciInfo(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      pciInfo_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public Builder clearPciInfo() {
      bitField0_ = (bitField0_ & ~0x00000004);
      pciInfo_ = getDefaultInstance().getPciInfo();
      onChanged();
      return this;
    }
    /**
     * <code>optional string pci_info = 3;</code>
     */
    public Builder setPciInfoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
      pciInfo_ = value;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:ProductCheckoutRequest)
  }

  static {
    defaultInstance = new ProductCheckoutRequest(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:ProductCheckoutRequest)
}

