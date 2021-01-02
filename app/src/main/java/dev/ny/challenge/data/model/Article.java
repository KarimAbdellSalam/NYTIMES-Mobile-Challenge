package dev.ny.challenge.data.model;

import androidx.databinding.BaseObservable;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Article extends BaseObservable implements Serializable {

    @SerializedName("uri")
    @Expose
    private String uri;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("asset_id")
    @Expose
    private long assetId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("published_date")
    @Expose
    private String publishedDate;
    @SerializedName("updated")
    @Expose
    private String updated;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("subsection")
    @Expose
    private String subsection;
    @SerializedName("nytdsection")
    @Expose
    private String nytdsection;
    @SerializedName("adx_keywords")
    @Expose
    private String adxKeywords;
    @SerializedName("byline")
    @Expose
    private String byline;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String _abstract;
    @SerializedName("des_facet")
    @Expose
    private List<String> desFacet = null;
    @SerializedName("org_facet")
    @Expose
    private List<Object> orgFacet = null;
    @SerializedName("per_facet")
    @Expose
    private List<Object> perFacet = null;
    @SerializedName("geo_facet")
    @Expose
    private List<Object> geoFacet = null;
    @SerializedName("media")
    @Expose
    private List<Medium> media = null;
    @SerializedName("eta_id")
    @Expose
    private Integer etaId;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
    }

    public String getNytdsection() {
        return nytdsection;
    }

    public void setNytdsection(String nytdsection) {
        this.nytdsection = nytdsection;
    }

    public String getAdxKeywords() {
        return adxKeywords;
    }

    public void setAdxKeywords(String adxKeywords) {
        this.adxKeywords = adxKeywords;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return _abstract;
    }

    public void setAbstract(String _abstract) {
        this._abstract = _abstract;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<Object> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<Object> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<Object> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<Object> perFacet) {
        this.perFacet = perFacet;
    }

    public List<Object> getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(List<Object> geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public Integer getEtaId() {
        return etaId;
    }

    public void setEtaId(Integer etaId) {
        this.etaId = etaId;
    }

    public class Medium extends BaseObservable implements Serializable {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("subtype")
        @Expose
        private String subtype;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("copyright")
        @Expose
        private String copyright;
        @SerializedName("approved_for_syndication")
        @Expose
        private Integer approvedForSyndication;
        @SerializedName("media-metadata")
        @Expose
        private List<MediaMetadatum> mediaMetadata = null;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getCopyright() {
            return copyright;
        }

        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Integer getApprovedForSyndication() {
            return approvedForSyndication;
        }

        public void setApprovedForSyndication(Integer approvedForSyndication) {
            this.approvedForSyndication = approvedForSyndication;
        }

        public List<MediaMetadatum> getMediaMetadata() {
            return mediaMetadata;
        }

        public void setMediaMetadata(List<MediaMetadatum> mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
        }
    }

    public class MediaMetadatum extends BaseObservable implements Serializable {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("format")
        @Expose
        private String format;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("width")
        @Expose
        private Integer width;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }
    }


    public String getHeaderImage() {
        if (!media.isEmpty()) {
            List<MediaMetadatum> mediaMetadata = media.get(0).getMediaMetadata();
            return findMedia(mediaMetadata, "mediumThreeByTwo440");
        }
        return null;
    }

    public String getImage() {
        if (!media.isEmpty()) {
            List<MediaMetadatum> mediaMetadata = media.get(0).getMediaMetadata();
            return findMedia(mediaMetadata, "Standard Thumbnail");
        }
        return null;
    }


    private String findMedia(List<MediaMetadatum> mediaMetadata, String format) {
        if (mediaMetadata == null)
            return null;
        Optional<MediaMetadatum> mediumThreeByTwo4401 = mediaMetadata.stream().filter(mediaMetadatum -> mediaMetadatum.format.equals(format)).findAny();
        return mediumThreeByTwo4401.map(mediaMetadatum -> mediaMetadatum.url).orElse(null);
    }

    public static class Mock {
        static String articleJson = "{\"uri\":\"nyt://article/8daa2079-70f3-58d1-ba62-c649354c4559\",\"url\":\"https://www.nytimes.com/2020/12/31/us/politics/trump-coronavirus.html\",\"id\":100000007522108,\"asset_id\":100000007522108,\"source\":\"New York Times\",\"published_date\":\"2020-12-31\",\"updated\":\"2021-01-01 11:26:46\",\"section\":\"U.S.\",\"subsection\":\"Politics\",\"nytdsection\":\"u.s.\",\"adx_keywords\":\"Coronavirus (2019-nCoV);Presidential Election of 2020;United States Politics and Government;Masks;Vaccination and Immunization;Tests (Medical);White House Coronavirus Outbreak (2020);Trump, Donald J;Atlas, Scott W;Birx, Deborah L;Fauci, Anthony S;Hahn, Stephen M (1960- );Kushner, Jared;Meadows, Mark R (1959- );Pence, Mike;Azar, Alex M II;Health and Human Services Department;Food and Drug Administration;Centers for Disease Control and Prevention;National Institutes of Health\",\"column\":null,\"byline\":\"By Michael D. Shear, Maggie Haberman, Noah Weiland, Sharon LaFraniere and Mark Mazzetti\",\"type\":\"Article\",\"title\":\"Trump’s Focus as the Pandemic Raged: What Would It Mean for Him?\",\"abstract\":\"President Trump missed his chance to show that he could rise to the moment in the final chapter of his presidency and meet the defining challenge of his tenure.\",\"des_facet\":[\"Coronavirus (2019-nCoV)\",\"Presidential Election of 2020\",\"United States Politics and Government\",\"Masks\",\"Vaccination and Immunization\",\"Tests (Medical)\",\"White House Coronavirus Outbreak (2020)\"],\"org_facet\":[\"Health and Human Services Department\",\"Food and Drug Administration\",\"Centers for Disease Control and Prevention\",\"National Institutes of Health\"],\"per_facet\":[\"Trump, Donald J\",\"Atlas, Scott W\",\"Birx, Deborah L\",\"Fauci, Anthony S\",\"Hahn, Stephen M (1960- )\",\"Kushner, Jared\",\"Meadows, Mark R (1959- )\",\"Pence, Mike\",\"Azar, Alex M II\"],\"geo_facet\":[],\"media\":[{\"type\":\"image\",\"subtype\":\"photo\",\"caption\":\"President Trump not only ended up soundly defeated by Joseph R. Biden Jr., but missed his chance to show that he could meet the defining challenge of his tenure.\",\"copyright\":\"Doug Mills/The New York Times\",\"approved_for_syndication\":1,\"media-metadata\":[{\"url\":\"https://static01.nyt.com/images/2020/12/31/us/politics/31dc-trump-virus-1/31dc-trump-virus-1-thumbStandard.jpg\",\"format\":\"Standard Thumbnail\",\"height\":75,\"width\":75},{\"url\":\"https://static01.nyt.com/images/2020/12/31/us/politics/31dc-trump-virus-1/31dc-trump-virus-1-mediumThreeByTwo210.jpg\",\"format\":\"mediumThreeByTwo210\",\"height\":140,\"width\":210},{\"url\":\"https://static01.nyt.com/images/2020/12/31/us/politics/31dc-trump-virus-1/31dc-trump-virus-1-mediumThreeByTwo440.jpg\",\"format\":\"mediumThreeByTwo440\",\"height\":293,\"width\":440}]}],\"eta_id\":0}";

        public static Article getArticle() {
            return new Gson().fromJson(articleJson, Article.class);
        }

        public static List<Article> getArticles() {
            List<Article> articles = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                articles.add(getArticle());
            }
            return articles;
        }
    }
}
