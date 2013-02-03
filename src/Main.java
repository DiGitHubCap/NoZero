/*
 * Disables fireworks on 'level up' to level 0 in LevelFlare.
 * Copyright (C) 2013 Andrew Stevanus (Hoot215) <hoot893@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import me.Hoot215.LevelFlare.api.LevelFlareLeveller;
import me.Hoot215.LevelFlare.api.LevelFlarePlayerLevelChangeEvent;
import me.Hoot215.LevelFlare.api.LevellerHandler;

@LevellerHandler(name = "NoZero", version = "1.0")
public class Main extends LevelFlareLeveller
  {
    @Override
    public void onPlayerLevelChange (LevelFlarePlayerLevelChangeEvent event)
      {
        if (event.getEvent().getNewLevel() == 0)
          {
            event.setCancelled(true);
          }
      }
    
    @Override
    public void onUnload ()
      {
        this.getPlugin().getLevellerManager()
            .unregisterPlayerLevelChangeEvent(this);
        this.getLogger().info("Is now unloaded");
      }
    
    @Override
    public void onLoad ()
      {
        this.getPlugin().getLevellerManager()
            .registerPlayerLevelChangeEvent(this);
        this.getLogger().info("Is now loaded");
      }
  }
