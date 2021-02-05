package de.tomgrill.gdxtesting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

import de.tomgrill.gdxtesting.GdxTestRunner;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

@RunWith(GdxTestRunner.class)
public class AssetTests {

    //Test for Music Assets
    @Test
    public void MusicExists() {
        assertTrue("This test will only pass when the music is detected.", Gdx.files
                .internal("../core/assets/Audio/Music/song.wav").exists());
    }

    //Tests for Sound Effects
    @Test
    public void SoundClickExits(){
        assertTrue("This test will only pass when the sound click is detected.", Gdx.files
                .internal("../core/assets/Audio/Sound Effects/click.wav").exists());
    }

    @Test
    public void SoundExplosionExits(){
        assertTrue("This test will only pass when the explosion sound is detected.", Gdx.files
                .internal("../core/assets/Audio/Sound Effects/explosion.wav").exists());
    }

    @Test
    public void SoundPassExists(){
        assertTrue("This test will only pass when the pass sound is detected.", Gdx.files
                .internal("../core/assets/Audio/Sound Effects/pass.wav").exists());
    }

    @Test
    public void SoundWrongExists(){
        assertTrue("This test will only pass when the sound for wrong is detected.", Gdx.files
                .internal("../core/assets/Audio/Sound Effects/wrong.wav").exists());
    }

    //Tests for Tileset/Tiled Files
    @Test
    public void TextureAtlasExists(){
        assertTrue("This test will only pass when the texture atlas is detected.", Gdx.files
                .internal("../core/assets/textures.atlas").exists());
    }

    @Test
    public void TexturePngExists(){
        assertTrue("This test will only pass when the texture png is detected.", Gdx.files
                .internal("../core/assets/textures.png").exists());
    }

    @Test
    public void TileMapTmxExists(){
        assertTrue("This test will only pass when the TileMap.tmx is detected.", Gdx.files
                .internal("../core/assets/TileMap.tmx").exists());
    }

    @Test
    public void TileSetTsxExists(){
        assertTrue("This test will only pass when Tileset.tsx is detected.", Gdx.files
                .internal("../core/assets/Tileset.tsx").exists());
    }

    @Test
    public void TileSetTwoPngExists(){
        assertTrue("This test will only pass when Tileset2.png is detected.", Gdx.files
                .internal("../core/assets/Audio/Sound Effects/wrong.wav").exists());
    }

    //LevelMenu Assets tests
    @Test
    public void EasyOffExists(){
        assertTrue("This test will only pass when EasyOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/EasyOff.png").exists());
    }

    @Test
    public void MedOffExists(){
        assertTrue("This test will only pass when MedOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/MedOff.png").exists());
    }

    @Test
    public void HardOffExists(){
        assertTrue("This test will only pass when HardOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/HardOff.png").exists());
    }

    @Test
    public void EasyOnExists(){
        assertTrue("This test will only pass when EasyOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/EasyOn.png").exists());
    }

    @Test
    public void MedOnExists(){
        assertTrue("This test will only pass when MedOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/MedOn.png").exists());
    }

    @Test
    public void HardOnExists(){
        assertTrue("This test will only pass when HardOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/LevelMenu/HardOn.png").exists());
    }

    //Menu Assets tests
    @Test
    public void BackOffExists(){
        assertTrue("This test will only pass when BackOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/BackOff.png").exists());
    }

    @Test
    public void ExitOnExists(){
        assertTrue("This test will only pass when ExitOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/ExitOn.png").exists());
    }

    @Test
    public void ExitOffExists(){
        assertTrue("This test will only pass when ExitOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/ExitOff.png").exists());
    }

    @Test
    public void LevelOffExists(){
        assertTrue("This test will only pass when LevelOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/LevelOff.png").exists());
    }

    @Test
    public void LevelOnExists(){
        assertTrue("This test will only pass when LevelOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/LevelOn.png").exists());
    }

    @Test
    public void LoadOffExists(){
        assertTrue("This test will only pass when LoadOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/LoadOff.png").exists());
    }

    @Test
    public void LoadOnExists(){
        assertTrue("This test will only pass when LoadOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/LoadOn.png").exists());
    }

    @Test
    public void MenuOffExists(){
        assertTrue("This test will only pass when MenuOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/MenuOff.png").exists());
    }

    @Test
    public void MenuOnExists(){
        assertTrue("This test will only pass when MenuOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/MenuOn.png").exists());
    }

    @Test
    public void MissionCompleteExists(){
        assertTrue("This test will only pass when MissionComplete.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/MissionComplete.png").exists());
    }

    @Test
    public void MissionFailedExists(){
        assertTrue("This test will only pass when MissionFailed.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/MissionFailed.png").exists());
    }

    @Test
    public void NewOffExists(){
        assertTrue("This test will only pass when NewOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/NewOff.png").exists());
    }

    @Test
    public void NewOnExists(){
        assertTrue("This test will only pass when NewOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/NewOn.png").exists());
    }

    @Test
    public void PauseMenuExists(){
        assertTrue("This test will only pass when Pause Menu.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/Pause Menu.png").exists());
    }

    @Test
    public void PlayOffExists(){
        assertTrue("This test will only pass when PlayOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/PlayOff.png").exists());
    }

    @Test
    public void PlayOnExists(){
        assertTrue("This test will only pass when PlayOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/PlayOn.png").exists());
    }

    @Test
    public void SaveOffExists(){
        assertTrue("This test will only pass when SaveOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/SaveOff.png").exists());
    }

    @Test
    public void SaveOnExists(){
        assertTrue("This test will only pass when SaveOn.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/SaveOn.png").exists());
    }

    @Test
    public void TitleExists(){
        assertTrue("This test will only pass when ExitOff.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Menu/exitOff.png").exists());
    }

    //MiniMap Assets tests
    @Test
    public void CursorExists(){
        assertTrue("This test will only pass when Cursor.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Minimap/Cursor.png").exists());
    }

    @Test
    public void MapExists(){
        assertTrue("This test will only pass when Map.png is detected.", Gdx.files
                .internal("../core/assets/Sprites/Minimap/Map.png").exists());
    }

    //TexturePack directory Test
    @Test
    public void TexturePackExists(){
        assertTrue("This test will only pass if TexturePack Directory Exists.", Gdx.files.
                internal("../core/assets/Sprites/TexturePack/").exists());
    }
}



