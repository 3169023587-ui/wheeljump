package io.github.3169023587-ui.wheeljump;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("wheeljump")
@Mod.EventBusSubscriber(modid = "wheeljump", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WheelJumpMod {

    public WheelJumpMod() {}

    @SubscribeEvent
    public static void onMouseScroll(InputEvent.MouseScrollingEvent event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.screen != null) return;
        if (event.getScrollDelta() < 0) {
            player.jumpFromGround();
            event.setCanceled(true);   
        }
    }
}
