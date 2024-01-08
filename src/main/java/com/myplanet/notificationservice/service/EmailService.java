package com.myplanet.notificationservice.service;

import com.myplanet.notificationservice.domain.Message;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    final Configuration configuration;

    @Autowired
    final JavaMailSender javaMailSender;

    public EmailService(Configuration configuration, JavaMailSender javaMailSender) {
        this.configuration = configuration;
        this.javaMailSender = javaMailSender;
    }

    public void sendAccountVerifyEmail(Message customMessage) throws MessagingException, IOException, TemplateException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(customMessage.getSubject());
        helper.setTo(customMessage.getToEmail());
        helper.setText(buildEmail(customMessage.getToken()),true);
        javaMailSender.send(mimeMessage);
    }

    private String buildEmail(String link) {
        return "<div class=\"es-wrapper-color\">\n" +
                "        <!--[if gte mso 9]>\n" +
                "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
                "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
                "\t\t\t</v:background>\n" +
                "\t\t<![endif]-->\n" +
                "        <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "            <tbody>\n" +
                "                <tr>\n" +
                "                    <td class=\"esd-email-paddings\" valign=\"top\">\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"esd-header-popover es-header\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#ffffff\" class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20t es-p10b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"560\" align=\"left\" class=\"esd-container-frame es-m-p20b\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image es-p15b\" style=\"font-size: 0px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_9765b1f53a585bf49aa1d928a7008949/images/group.png\" alt=\"Logo\" style=\"display: block;\" height=\"70\" title=\"Logo\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-menu\" esd-tmp-divider=\"1|solid|#999999\" esd-tmp-menu-font-size=\"12px\" esd-tmp-menu-font-weight=\"normal\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr class=\"links\">\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"33.33%\" class=\"es-p10t es-p10b es-p5r es-p5l\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">HEALTH & WELLBEING</a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"33.33%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"border-left: 1px solid #999999;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">SKINCARE & BEAUTY</a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"33.33%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"border-left: 1px solid #999999;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">FOOD & DRINK</a></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20b\" align=\"left\">\n" +
                "                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td class=\"es-m-p0r esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\n" +
                "                                                                        <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_f4f8be13dd07ed085a349f5fd969d18a/images/5657176_1_ogI.png\" alt=\"Greenpeace day\" style=\"display: block;\" width=\"600\" title=\"Greenpeace day\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#A8D87E\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20t es-p20b es-p40r es-p40l es-m-p20r es-m-p20l\" align=\"left\" background=\"https://tlr.stripocdn.email/content/guids/CABINET_f4f8be13dd07ed085a349f5fd969d18a/images/group_32_Dyn.png\" style=\"background-image: url(https://tlr.stripocdn.email/content/guids/CABINET_f4f8be13dd07ed085a349f5fd969d18a/images/group_32_Dyn.png); background-repeat: no-repeat; background-position: center bottom;\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"520\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p10b\">\n" +
                "                                                                                        <p style=\"font-size: 14px;\"><br></p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-m-txt-c es-p10t es-p10b es-p40r es-p40l es-m-p0r es-m-p0l\">\n" +
                "                                                                                        <h1 style=\"line-height: 120%;\">My Planet</h1>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-m-txt-c es-p5t es-p5b es-p40r es-p40l es-m-p0r es-m-p0l\">\n" +
                "                                                                                        <h3 style=\"line-height: 120%;\"><br></h3>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p30b es-p40r es-p40l es-m-p0r es-m-p0l\">\n" +
                "                                                                                        <p style=\" line-height: 150%;\">In order to validate your account, please click the link below.</p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-button es-p35b\">\n" +
                "                                                                                        <!--[if mso]><a href=\"https://viewstripo.email\" target=\"_blank\" hidden>\n" +
                "\t<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"https://viewstripo.email\" \n" +
                "                style=\"height:44px; v-text-anchor:middle; width:236px\" arcsize=\"34%\" stroke=\"f\"  fillcolor=\"#02604d\">\n" +
                "\t\t<w:anchorlock></w:anchorlock>\n" +
                "\t\t<center style='color:#f6f3eb; font-family:helvetica, \"helvetica neue\", arial, verdana, sans-serif; font-size:18px; font-weight:700; line-height:18px;  mso-text-raise:1px'>Validate account</center>\n" +
                "\t</v:roundrect></a>\n" +
                "<![endif]-->\n" +
                "                                                                                        <!--[if !mso]><!-- --><span class=\"es-button-border msohide\"><a href=\""+link+"\" class=\"es-button\" target=\"_blank\">Validate account</a></span>\n" +
                "                                                                                        <!--<![endif]-->\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"600\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_f4f8be13dd07ed085a349f5fd969d18a/images/group_36.png\" alt style=\"display: block;\" width=\"600\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img class=\"adapt-img\" src=\"https://tlr.stripocdn.email/content/guids/CABINET_f4f8be13dd07ed085a349f5fd969d18a/images/group_34_QzO.png\" alt style=\"display: block;\" width=\"600\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"esd-footer-popover es-footer\" align=\"center\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td class=\"esd-stripe\" align=\"center\">\n" +
                "                                        <table bgcolor=\"#ffffff\" class=\"es-footer-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\">\n" +
                "                                            <tbody>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20t es-p20b es-p20r es-p20l\" align=\"left\" esd-custom-block-id=\"590935\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"560\" class=\"esd-container-frame\" align=\"left\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td class=\"esd-block-menu\" esd-tmp-menu-padding=\"10|10\" esd-tmp-menu-color=\"#402218\" esd-tmp-menu-font-size=\"12px\" esd-tmp-menu-font-weight=\"normal\" esd-tmp-divider=\"1|solid|#999999\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" class=\"es-menu\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr class=\"links\">\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"25%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 10px;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">ABOUT US</a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"25%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 10px; border-left: 1px solid #999999;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">NEWS</a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"25%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 10px; border-left: 1px solid #999999;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">CAREER</a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" width=\"25%\" class=\"es-p10t es-p10b es-p5r es-p5l\" style=\"padding-bottom: 10px; border-left: 1px solid #999999;\"><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"font-size: 12px; font-weight: normal;\">THE SHOPS</a></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-social es-p10t es-p10b\" style=\"font-size:0\">\n" +
                "                                                                                        <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\">\n" +
                "                                                                                            <tbody>\n" +
                "                                                                                                <tr>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p20r\" esd-tmp-icon-type=\"facebook\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Facebook\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-colored/facebook-logo-colored.png\" alt=\"Fb\" width=\"24\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p20r\" esd-tmp-icon-type=\"twitter\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Twitter\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-colored/twitter-logo-colored.png\" alt=\"Tw\" width=\"24\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" class=\"es-p20r\" esd-tmp-icon-type=\"instagram\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Instagram\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-colored/instagram-logo-colored.png\" alt=\"Inst\" width=\"24\" height=\"24\"></a></td>\n" +
                "                                                                                                    <td align=\"center\" valign=\"top\" esd-tmp-icon-type=\"youtube\"><a target=\"_blank\" href=\"https://viewstripo.email\"><img title=\"Youtube\" src=\"https://tlr.stripocdn.email/content/assets/img/social-icons/logo-colored/youtube-logo-colored.png\" alt=\"Yt\" width=\"24\" height=\"24\"></a></td>\n" +
                "                                                                                                </tr>\n" +
                "                                                                                            </tbody>\n" +
                "                                                                                        </table>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-text es-p10t es-p10b\" esd-links-underline=\"none\">\n" +
                "                                                                                        <p>You are receiving this email because you have visited our site or asked us about the regular newsletter. Make sure our messages get to your Inbox (and not your bulk or junk folders).<br><a target=\"_blank\" href=\"https://viewstripo.email\" style=\"text-decoration: none;\">Privacy police</a> | <a target=\"_blank\" style=\"text-decoration: none;\">Unsubscribe</a></p>\n" +
                "                                                                                    </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td class=\"esd-structure es-p20t es-p20b es-p20r es-p20l\" align=\"left\">\n" +
                "                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                            <tbody>\n" +
                "                                                                <tr>\n" +
                "                                                                    <td width=\"560\" class=\"es-m-p20b esd-container-frame\" align=\"left\">\n" +
                "                                                                        <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                "                                                                            <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                    <td align=\"center\" class=\"esd-block-image es-infoblock made_with\" style=\"font-size:0\"><a target=\"_blank\" href=\"https://viewstripo.email/?utm_source=templates&utm_medium=email&utm_campaign=food_6&utm_content=volunteer_with_greenpeace\"><img src=\"https://tlr.stripocdn.email/content/guids/CABINET_09023af45624943febfa123c229a060b/images/7911561025989373.png\" alt width=\"125\" style=\"display: block;\"></a></td>\n" +
                "                                                                                </tr>\n" +
                "                                                                            </tbody>\n" +
                "                                                                        </table>\n" +
                "                                                                    </td>\n" +
                "                                                                </tr>\n" +
                "                                                            </tbody>\n" +
                "                                                        </table>\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div>";
    }
}
