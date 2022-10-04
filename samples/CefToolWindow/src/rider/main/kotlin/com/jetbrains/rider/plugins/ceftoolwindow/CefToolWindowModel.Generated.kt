@file:Suppress("EXPERIMENTAL_API_USAGE","EXPERIMENTAL_UNSIGNED_LITERALS","PackageDirectoryMismatch","UnusedImport","unused","LocalVariableName","CanBeVal","PropertyName","EnumEntryName","ClassName","ObjectPropertyName","UnnecessaryVariable","SpellCheckingInspection")
package com.jetbrains.rd.ide.model

import com.jetbrains.rd.framework.*
import com.jetbrains.rd.framework.base.*
import com.jetbrains.rd.framework.impl.*

import com.jetbrains.rd.util.lifetime.*
import com.jetbrains.rd.util.reactive.*
import com.jetbrains.rd.util.string.*
import com.jetbrains.rd.util.*
import kotlin.reflect.KClass
import kotlin.jvm.JvmStatic



/**
 * #### Generated from [CefToolWindowModel.kt:12]
 */
class CefToolWindowModel private constructor(
    private val _toolWindowContent: RdOptionalProperty<com.jetbrains.ide.model.uiautomation.BeControl>,
    private val _activateToolWindow: RdOptionalProperty<Boolean>
) : RdExtBase() {
    //companion
    
    companion object : ISerializersOwner {
        
        override fun registerSerializersCore(serializers: ISerializers)  {
            serializers.register(BeCefToolWindowPanel)
        }
        
        
        @JvmStatic
        @JvmName("internalCreateModel")
        @Deprecated("Use create instead", ReplaceWith("create(lifetime, protocol)"))
        internal fun createModel(lifetime: Lifetime, protocol: IProtocol): CefToolWindowModel  {
            @Suppress("DEPRECATION")
            return create(lifetime, protocol)
        }
        
        @JvmStatic
        @Deprecated("Use protocol.cefToolWindowModel or revise the extension scope instead", ReplaceWith("protocol.cefToolWindowModel"))
        fun create(lifetime: Lifetime, protocol: IProtocol): CefToolWindowModel  {
            IdeRoot.register(protocol.serializers)
            
            return CefToolWindowModel().apply {
                identify(protocol.identity, RdId.Null.mix("CefToolWindowModel"))
                bind(lifetime, protocol, "CefToolWindowModel")
            }
        }
        
        
        const val serializationHash = 4418284180864526030L
        
    }
    override val serializersOwner: ISerializersOwner get() = CefToolWindowModel
    override val serializationHash: Long get() = CefToolWindowModel.serializationHash
    
    //fields
    val toolWindowContent: IOptProperty<com.jetbrains.ide.model.uiautomation.BeControl> get() = _toolWindowContent
    val activateToolWindow: IOptProperty<Boolean> get() = _activateToolWindow
    //methods
    //initializer
    init {
        _activateToolWindow.optimizeNested = true
    }
    
    init {
        bindableChildren.add("toolWindowContent" to _toolWindowContent)
        bindableChildren.add("activateToolWindow" to _activateToolWindow)
    }
    
    //secondary constructor
    private constructor(
    ) : this(
        RdOptionalProperty<com.jetbrains.ide.model.uiautomation.BeControl>(AbstractPolymorphic(com.jetbrains.ide.model.uiautomation.BeControl)),
        RdOptionalProperty<Boolean>(FrameworkMarshallers.Bool)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("CefToolWindowModel (")
        printer.indent {
            print("toolWindowContent = "); _toolWindowContent.print(printer); println()
            print("activateToolWindow = "); _activateToolWindow.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): CefToolWindowModel   {
        return CefToolWindowModel(
            _toolWindowContent.deepClonePolymorphic(),
            _activateToolWindow.deepClonePolymorphic()
        )
    }
    //contexts
}
val IProtocol.cefToolWindowModel get() = getOrCreateExtension(CefToolWindowModel::class) { @Suppress("DEPRECATION") CefToolWindowModel.create(lifetime, this) }



/**
 * #### Generated from [CefToolWindowModel.kt:21]
 */
class BeCefToolWindowPanel private constructor(
    val url: String?,
    val html: String?,
    private val _openDevTools: RdSignal<Boolean>,
    private val _openUrl: RdSignal<String>,
    private val _getResource: RdCall<String, String>,
    _enabled: RdProperty<Boolean>,
    _controlId: RdProperty<String>,
    _tooltip: RdProperty<@org.jetbrains.annotations.Nls String?>,
    _focus: RdSignal<Unit>,
    _visible: RdOptionalProperty<com.jetbrains.ide.model.uiautomation.ControlVisibility>
) : com.jetbrains.ide.model.uiautomation.BeControl (
    _enabled,
    _controlId,
    _tooltip,
    _focus,
    _visible
) {
    //companion
    
    companion object : IMarshaller<BeCefToolWindowPanel> {
        override val _type: KClass<BeCefToolWindowPanel> = BeCefToolWindowPanel::class
        
        @Suppress("UNCHECKED_CAST")
        override fun read(ctx: SerializationCtx, buffer: AbstractBuffer): BeCefToolWindowPanel  {
            val _id = RdId.read(buffer)
            val _enabled = RdProperty.read(ctx, buffer, FrameworkMarshallers.Bool)
            val _controlId = RdProperty.read(ctx, buffer, FrameworkMarshallers.String)
            val _tooltip = RdProperty.read(ctx, buffer, __StringNullableSerializer)
            val _focus = RdSignal.read(ctx, buffer, FrameworkMarshallers.Void)
            val _visible = RdOptionalProperty.read(ctx, buffer, com.jetbrains.ide.model.uiautomation.ControlVisibility.marshaller)
            val url = buffer.readNullable { buffer.readString() }
            val html = buffer.readNullable { buffer.readString() }
            val _openDevTools = RdSignal.read(ctx, buffer, FrameworkMarshallers.Bool)
            val _openUrl = RdSignal.read(ctx, buffer, FrameworkMarshallers.String)
            val _getResource = RdCall.read(ctx, buffer, FrameworkMarshallers.String, FrameworkMarshallers.String)
            return BeCefToolWindowPanel(url, html, _openDevTools, _openUrl, _getResource, _enabled, _controlId, _tooltip, _focus, _visible).withId(_id)
        }
        
        override fun write(ctx: SerializationCtx, buffer: AbstractBuffer, value: BeCefToolWindowPanel)  {
            value.rdid.write(buffer)
            RdProperty.write(ctx, buffer, value._enabled)
            RdProperty.write(ctx, buffer, value._controlId)
            RdProperty.write(ctx, buffer, value._tooltip)
            RdSignal.write(ctx, buffer, value._focus)
            RdOptionalProperty.write(ctx, buffer, value._visible)
            buffer.writeNullable(value.url) { buffer.writeString(it) }
            buffer.writeNullable(value.html) { buffer.writeString(it) }
            RdSignal.write(ctx, buffer, value._openDevTools)
            RdSignal.write(ctx, buffer, value._openUrl)
            RdCall.write(ctx, buffer, value._getResource)
        }
        
        private val __StringNullableSerializer = FrameworkMarshallers.String.nullable()
        
    }
    //fields
    val openDevTools: ISignal<Boolean> get() = _openDevTools
    val openUrl: ISignal<String> get() = _openUrl
    val getResource: IRdCall<String, String> get() = _getResource
    //methods
    //initializer
    init {
        _getResource.async = true
    }
    
    init {
        bindableChildren.add("openDevTools" to _openDevTools)
        bindableChildren.add("openUrl" to _openUrl)
        bindableChildren.add("getResource" to _getResource)
    }
    
    //secondary constructor
    constructor(
        url: String?,
        html: String?
    ) : this(
        url,
        html,
        RdSignal<Boolean>(FrameworkMarshallers.Bool),
        RdSignal<String>(FrameworkMarshallers.String),
        RdCall<String, String>(FrameworkMarshallers.String, FrameworkMarshallers.String),
        RdProperty<Boolean>(true, FrameworkMarshallers.Bool),
        RdProperty<String>("", FrameworkMarshallers.String),
        RdProperty<@org.jetbrains.annotations.Nls String?>(null, __StringNullableSerializer),
        RdSignal<Unit>(FrameworkMarshallers.Void),
        RdOptionalProperty<com.jetbrains.ide.model.uiautomation.ControlVisibility>(com.jetbrains.ide.model.uiautomation.ControlVisibility.marshaller)
    )
    
    //equals trait
    //hash code trait
    //pretty print
    override fun print(printer: PrettyPrinter)  {
        printer.println("BeCefToolWindowPanel (")
        printer.indent {
            print("url = "); url.print(printer); println()
            print("html = "); html.print(printer); println()
            print("openDevTools = "); _openDevTools.print(printer); println()
            print("openUrl = "); _openUrl.print(printer); println()
            print("getResource = "); _getResource.print(printer); println()
            print("enabled = "); _enabled.print(printer); println()
            print("controlId = "); _controlId.print(printer); println()
            print("tooltip = "); _tooltip.print(printer); println()
            print("focus = "); _focus.print(printer); println()
            print("visible = "); _visible.print(printer); println()
        }
        printer.print(")")
    }
    //deepClone
    override fun deepClone(): BeCefToolWindowPanel   {
        return BeCefToolWindowPanel(
            url,
            html,
            _openDevTools.deepClonePolymorphic(),
            _openUrl.deepClonePolymorphic(),
            _getResource.deepClonePolymorphic(),
            _enabled.deepClonePolymorphic(),
            _controlId.deepClonePolymorphic(),
            _tooltip.deepClonePolymorphic(),
            _focus.deepClonePolymorphic(),
            _visible.deepClonePolymorphic()
        )
    }
    //contexts
}
