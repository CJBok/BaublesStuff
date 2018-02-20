/*
 * This class (GuiFactory.java) was created by <zazpro>. It's distributed as
 * part of the Baubles Stuff Mod. Get the Source Code in github:
 * https://github.com/ZAZPRO/BaublesStuff
 *
 * Baubles Stuff is Open Source and distributed under the
 * Baubles Stuff License: https://github.com/ZAZPRO/BaublesStuff/blob/master/LICENSE.MD
 *
 * © 2016 zazpro
 */

package md.zazpro.mod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

public class GuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

	@Override
	public boolean hasConfigGui() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) {
		// TODO Auto-generated method stub
		return null;
	}
}
