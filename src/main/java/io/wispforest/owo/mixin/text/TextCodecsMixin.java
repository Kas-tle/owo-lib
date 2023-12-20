package io.wispforest.owo.mixin.text;

import io.wispforest.owo.text.CustomTextRegistry;
import net.minecraft.text.TextCodecs;
import net.minecraft.text.TextContent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(TextCodecs.class)
public abstract class TextCodecsMixin {

    @ModifyArgs(method = "createCodec", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/TextCodecs;dispatchingCodec([Lnet/minecraft/util/StringIdentifiable;Ljava/util/function/Function;Ljava/util/function/Function;Ljava/lang/String;)Lcom/mojang/serialization/MapCodec;", ordinal = 0))
    private static void modifyDispatchingCodecArgs(Args args) {
        List<TextContent.Type<?>> typesList = new ArrayList<>(Arrays.asList(args.get(0)));
        typesList.addAll(CustomTextRegistry.typesMap().values().stream().map(CustomTextRegistry.Entry::type).toList());
        args.set(0, typesList.toArray(new TextContent.Type<?>[0]));
    }

}

