package de.tomgrill.gdxtesting;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.badlogic.gdx.Gdx;

import de.tomgrill.gdxtesting.GdxTestRunner;

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
    //MiniMap Assets tests
    //TexturePack Assets tests
}



